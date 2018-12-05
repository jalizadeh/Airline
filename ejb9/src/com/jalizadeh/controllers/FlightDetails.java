package com.jalizadeh.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightLocal_ejb8;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName = "flightStateless")
	private FlightLocal_ejb8 fs;
	
	@EJB(beanName = "flightStateless")
	private FlightLocal_ejb8 fs2;
	
	@EJB(beanName = "flightStateful")
	private FlightLocal_ejb8 fsStateful;
	
	@EJB(beanName = "flightStateful")
	private FlightLocal_ejb8 fsStateful2;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("[stateless:fs] Flight details: "+ fs.getFrom() + " -> " + fs.getTo());
		out.println("[stateful:fsStateful] Flight details: "+ fsStateful.getFrom() + " -> " + fsStateful.getTo());
	
		out.println();
		
		fs2.setFrom("Rasht");
		fs2.setTo("Tehran");
		out.println("[stateless:fs] Flight details: "+ fs.getFrom() + " -> " + fs.getTo());
		out.println("[stateless:fs2] Flight details: "+ fs2.getFrom() + " -> " + fs2.getTo());
		
		out.println();
		
		fsStateful2.setFrom("Rasht");
		fsStateful2.setTo("Tehran");
		out.println("[stateful:fsStateful] Flight details: "+ fsStateful.getFrom() + " -> " + fsStateful.getTo());
		out.println("[stateful:fsStateful2] Flight details: "+ fsStateful2.getFrom() + " -> " + fsStateful2.getTo());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
