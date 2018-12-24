package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Flight;
import com.airline.models.Pilot;

/**
 * Session Bean implementation class PilotService
 */
@Stateless
@LocalBean
public class PilotService {

	@PersistenceContext(name = "airline")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PilotService() {
        // TODO Auto-generated constructor stub
    }

    
    public void addPilot(Pilot p) {
    	em.persist(p);
    }
    
    /**
     * Get the objects of Pilot and Flight from the database via "NamedQuery"
     * @see Flight
     * @see Pilot
     * 
     * @param pilotId
     * @param flightId
     */
    public void addNewPilotToFlight(Pilot p, String flightId) {

    	//"p" is a regular Java Object which is needed to be saved into DB at first 
    	em.persist(p);
    	
    	//find the flight by id
    	TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById", Flight.class);
    	fQuery.setParameter("id",Integer.parseInt(flightId));
    	Flight f = fQuery.getSingleResult();
    	
    	//add the pilot to the flight & the flight for pilot
    	List<Pilot> pList = f.getPilots();
    	pList.add(p);
    	f.setPilots(pList);
    	p.setFlightForPilot(f);
    }
}
