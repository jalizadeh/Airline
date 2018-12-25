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
	
}
