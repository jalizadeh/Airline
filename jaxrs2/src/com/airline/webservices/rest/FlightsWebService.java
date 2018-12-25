package com.airline.webservices.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.airline.service.FlightService;

@Path("/flights")
public class FlightsWebService {

	@PersistenceContext(unitName="airline")
	EntityManager em;
	
	@EJB
	FlightService fs;
	
	@Context
	UriInfo fUrinInfo;
	
	public FlightsWebService() {
		
	}
}
