package com.airline.webservices.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
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
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{passenger_id}")
	public Passenger getPassenger(@PathParam("passenger_id") Integer passengerId) {
		Passenger p = ps.getPassenger(passengerId);
		
		if(p == null) 
			throw new NotFoundException("The passenger with id=" + passengerId + " was not found.");
		
		return p;
	}
	
	
	/**
	 * It will receive the passenger from user & put it in DB<br/>
	 * The URL of the new passenger is produced automatically
	 * 
	 * @param p
	 * @return uri of the new p <br/>
	 * 		http://localhost:8080/jaxrs5/airlineservices/rest/passengers/X
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPassenger(Passenger p) {
		//this p will have all the data + automatic Id which will be used later
		p = ps.addPassengerAndReturnIt(p);
		
		UriBuilder pUriBuilder = pUrinInfo.getAbsolutePathBuilder();
		URI pUri = pUriBuilder.path( String.valueOf(p.getId()) ).build();
		
		return Response.created(pUri).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/edit/{pId}")
	public Response updatePassenger(@PathParam("pId") Integer passengerId, Passenger pUpdated) {
		pUpdated = ps.updatePassenger(passengerId, pUpdated);
		
		if(pUpdated == null)
			throw new NotFoundException("The passenger with id=" + passengerId + " was not found.");
		
		return Response.ok(pUpdated).build();
	}
	
	
	//another way of editing an item
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/edit2/{pId}")
	public Response updatePassenger2(@PathParam("pId") Integer passengerId, Passenger pUpdated) {
		pUpdated = ps.updatePassenger(passengerId, pUpdated);
		
		if(pUpdated == null)
			throw new NotFoundException("The passenger with id=" + passengerId + " was not found.");
		
		return Response.ok(pUpdated).build();
	}
}
