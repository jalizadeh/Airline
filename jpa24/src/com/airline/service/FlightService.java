package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.models.Pilot;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService {

    /**
     * Default constructor. 
     */
    public FlightService() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName = "airline")
    EntityManager em;
    
    
    public void addFlight(Flight f, Airplane a) {
    	em.persist(f);
    	
    	//cascaded & propagated from Flight object automatically
    	//em.persist(a);
    }
    
    /**
     * Get the objects of Pilot and Flight from the database via "NamedQuery"
     * @see Flight
     * @see Pilot
     * 
     * @param pilotId
     * @param flightId
     */
    public void addPilotToFlight(String pilotId, String flightId) {

    	//find the flight by id
    	TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById", Flight.class);
    	fQuery.setParameter("id",Integer.parseInt(flightId));
    	Flight f = fQuery.getSingleResult();
    	
    	//find the pilot by id
    	TypedQuery<Pilot> pQuery = em.createNamedQuery("Pilot.findById", Pilot.class);
    	pQuery.setParameter("id", Integer.parseInt(pilotId));
    	Pilot p = pQuery.getSingleResult();
    	
    	//add the pilot to the flight & the flight for pilot
    	List<Pilot> pList = f.getPilots();
    	pList.add(p);
    	f.setPilots(pList);
    	p.setFlightForPilot(f);
    	
    }
    
    
    
    public List<Flight> getFlights(){
    	TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f", Flight.class);
    	List<Flight> fList = query.getResultList();
    	return fList;
    }

	public void addPassengerToFlight(String passengerId, String flightId) {
		
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
	}
}
