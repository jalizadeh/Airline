package com.jalizadeh.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightService;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * NOTE: it is not allowed to use 
	 * 		<private FlightService fs = new FlightService();>
	 * 		otherwise, we won`t use the benefits of EJB
	 */
	@EJB
	private FlightService fs;
	
	@EJB
	private FlightService fs2;
	
	@EJB
	private FlightService fs3;
	
	@EJB
	private FlightService fs4;
       
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
		
		fs.setFrom("London");
		out.println(fs.getFrom());

		fs2.setFrom("Rome");
		out.println(fs.getFrom());
		
		fs3.setFrom("Rasht");
		out.println(fs.getFrom());
		
		fs4.setFrom("Turin");
		out.println(fs.getFrom());
		
		/**
		 * The result is:
		 * 		London
		 * 		Rome
		 * 		Rasht
		 * 		Turin
		 * 
		 * because, the bean "FlightService" is "@Stateless"
		 * all the fs2, fs3, fs4, fsX will refer to "fs" object
		 * 
		 * in fact, in each line I`m changing the "from" parameter
		 * of "fs"
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
