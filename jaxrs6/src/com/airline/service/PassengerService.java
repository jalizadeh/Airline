package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.airline.models.Flight;
import com.airline.models.Passenger;

/**
 * Session Bean implementation class PassengerService
 */
@Stateless
@LocalBean
public class PassengerService {

    /**
     * Default constructor. 
     */
    public PassengerService() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext(unitName="airline")
    private EntityManager em;

    
    public void addPassenger(Passenger p) {
    	em.persist(p);
    }
    
    
    //jaxrs5
    //I need this method for POST operation 
    public Passenger addPassengerAndReturnIt(Passenger p) {
    	em.persist(p);
    	return p;
    }
    
    public List<Passenger> getPassengers(){
    	TypedQuery<Passenger> query = em.createQuery("SELECT p FROM Passenger p", Passenger.class);
    	List<Passenger> pList = query.getResultList();
    	return pList;
    }

	public void addFlightTicketToPassenger(String passengerId, String flightId) {

		//Get Passenger by id
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Passenger> cqPassenger = builder.createQuery(Passenger.class);
		Root<Passenger> pRoot = cqPassenger.from(Passenger.class);
		cqPassenger.select(pRoot).where(builder.equal(pRoot.get("id").as(Integer.class), passengerId));
		TypedQuery<Passenger> pQuery = em.createQuery(cqPassenger);
		Passenger p = pQuery.getSingleResult();
		
		//Get Flight by id
		builder = em.getCriteriaBuilder();
		CriteriaQuery<Flight> cqFlight = builder.createQuery(Flight.class);
		Root<Flight> fRoot = cqFlight.from(Flight.class);
		cqFlight.select(fRoot).where(builder.equal(fRoot.get("id").as(Integer.class), flightId));
		TypedQuery<Flight> fQuery = em.createQuery(cqFlight);
		Flight f = fQuery.getSingleResult();
		
		List<Flight> fList = p.getFlights();
		fList.add(f);
		p.setFlights(fList);

		f.getPassengers().add(p);
	} 
	
	public Passenger getPassenger(Integer passengerId) {
		//Get Passenger by id
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Passenger> cqPassenger = builder.createQuery(Passenger.class);
		Root<Passenger> pRoot = cqPassenger.from(Passenger.class);
		cqPassenger.select(pRoot).where(builder.equal(pRoot.get("id").as(Integer.class), passengerId));
		TypedQuery<Passenger> pQuery = em.createQuery(cqPassenger);
		Passenger p = null;
		
		try {
			p = pQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
		return p;
	}
	
	
	public Passenger updatePassenger(Integer passengerId, Passenger pUpdated) {
		//Find by primary key. 
		//Search for an entity of the specified class and primary key. 
		//If the entity instance is contained in the persistence context, it is returned from there.
		Passenger p = em.find(Passenger.class, passengerId);
		
		if(p == null)
			return null;
		
		if(pUpdated.getFirstName() != null)
			p.setFirstName(pUpdated.getFirstName());
		
		if(pUpdated.getLastName() != null)
			p.setLastName(pUpdated.getLastName());
		
		if(pUpdated.getDob() != null)
			p.setDob(pUpdated.getDob());
		
		if(pUpdated.getGender() != null)
			p.setGender(pUpdated.getGender());
			
		return p;
	}
	
}
