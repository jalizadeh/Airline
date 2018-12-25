package com.airline.webservices.rest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.airline.service.PassengerService;

@Path("/passengers")
public class PassengersWebService {

	@PersistenceContext(unitName="airline")
	EntityManager em;
	
	@EJB
	PassengerService ps;
	
	@Context
	UriInfo pUrinInfo;
	
	public PassengersWebService() {
		
	}
}
