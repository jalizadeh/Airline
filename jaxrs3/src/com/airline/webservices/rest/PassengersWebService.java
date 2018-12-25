package com.airline.webservices.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.airline.models.Passenger;
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
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Passenger> getPassengers(){
		List<Passenger> pList = ps.getPassengers();
		return pList;
	}
}
