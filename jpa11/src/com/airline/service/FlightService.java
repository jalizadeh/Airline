package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Airplane;
import com.airline.models.Flight;
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
    	em.persist(a);
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
}
