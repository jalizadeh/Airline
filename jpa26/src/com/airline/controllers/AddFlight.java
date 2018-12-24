package com.airline.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
import com.airline.service.FlightService;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	FlightService fs;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Flight f = new Flight();
		
		f.setFlightOrigin(FlightDestinations.valueOf(request.getParameter("from_destination")));
		f.setFlightDestination(FlightDestinations.valueOf(request.getParameter("to_destination")));
		f.setPrice(Integer.parseInt(request.getParameter("price")));
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(request.getParameter("year")));
		cal.set(Calendar.MONTH, Integer.parseInt(request.getParameter("month")));
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("day")));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(request.getParameter("hour")));
		cal.set(Calendar.MINUTE, Integer.parseInt(request.getParameter("minute")));
		
		Date flightTime = cal.getTime();
		//System.out.println(flightTime);
		f.setFlightTime(flightTime);
		
		Airplane a = new Airplane();
		a.setModelName(request.getParameter("airplane_model"));
		a.setPlaneMake(request.getParameter("airplane_make"));
		a.setSeatingCapacity(Integer.parseInt(request.getParameter("airplane_seating")));
		
		f.setAirplaneDetail(a);
		
		//System.out.println(f);
		//System.out.println(a);
		
		fs.addFlight(f, a);
		
		response.sendRedirect("Flights");
	}

}
