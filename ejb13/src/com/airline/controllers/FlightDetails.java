package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightLocal_ejb13;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//@EJB(beanName = "flightStateless")
	private FlightLocal_ejb13 fs;

	//@EJB(beanName = "flightStateful")
	private FlightLocal_ejb13 fsStateful;

	
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
		
		try {
			Context context = new InitialContext();
			//this time, the bean`s name is used
			Object fsObj = context.lookup("java:global/ejb10/flightStateless!com.airline.service.FlightLocal_ejb10");
			this.fs = (FlightLocal_ejb13) fsObj;
			
			//this time, the bean`s name is used
			Object fsStatefulObj = context.lookup("java:global/ejb10/flightStateful!com.airline.service.FlightLocal_ejb10");
			this.fsStateful = (FlightLocal_ejb13) fsStatefulObj;
		
			PrintWriter out = response.getWriter();
			out.println("[stateless:fs] Flight details: "+ fs.getFrom() + " -> " + fs.getTo());
			out.println("[stateful:fsStateful] Flight details: "+ fsStateful.getFrom() + " -> " + fsStateful.getTo());
			
		} catch(NamingException e) {
			e.printStackTrace();
		}
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
