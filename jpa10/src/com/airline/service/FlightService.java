package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Pilot;
import com.airline.models.PilotRank;

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
    	TypedQuery<Flight> fQuery = em.createQuery("Flight.findById", Flight.class);
    	fQuery.setParameter("id",Integer.parseInt(flightId));
    	Flight f = fQuery.getSingleResult();
    	
    	TypedQuery<Pilot> pQuery = em.createNamedQuery("Pilot.findById", Pilot.class);
    	pQuery.setParameter("id", pilotId);
    	Pilot p = pQuery.getSingleResult();
    }
}
