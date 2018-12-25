package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;

/**
 * Servlet implementation class CreatePilotAndAddToFlight
 */
@WebServlet("/CreatePilotAndAddToFlight")
public class CreatePilotAndAddToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	PilotService ps;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePilotAndAddToFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pilot p = new Pilot();
		
		p.setFirstName(request.getParameter("first_name"));
		p.setLastName(request.getParameter("last_name"));
		p.setPilotLicense(Integer.parseInt(request.getParameter("license")));
		p.setPilotRank(PilotRank.valueOf(request.getParameter("pilot_rank")));
		
		//the newly "p" object must be saved into DB, then be added to Flight
		ps.addNewPilotToFlight(p, request.getParameter("fid"));
		
		response.sendRedirect("Flights");
	}

}
