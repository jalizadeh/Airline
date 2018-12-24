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

import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	PassengerService ps;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
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
		Passenger p = new Passenger();
		
		p.setFirstName(request.getParameter("first_name"));
		p.setLastName(request.getParameter("last_name"));
		
		String dob_raw = request.getParameter("dob");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(dob_raw.split("\\/")[2]));
		cal.set(Calendar.MONTH, Integer.parseInt(dob_raw.split("\\/")[0])); //month starts from 0
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dob_raw.split("\\/")[1]));
		Date dob = cal.getTime();
		p.setDob(dob);
		
		p.setGender(Gender.valueOf(request.getParameter("gender")));
		
		//not used here
		//p.setFlightClass(FlightClass.Coach);
		
		//System.out.println(p);
		
		ps.addPassenger(p);
		
		response.sendRedirect("Passengers");
	}

}
