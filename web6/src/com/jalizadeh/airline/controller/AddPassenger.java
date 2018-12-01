package com.jalizadeh.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPassenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		
		//setting date of birth 
		String dob_raw = request.getParameter("dob");
		String[] dobItems = dob_raw.split("\\/");
		String month = dobItems[0];
		String day = dobItems[1];
		String year = dobItems[2];
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month));
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		
		Date dob = cal.getTime();	
		//----
		
		String gender = request.getParameter("gender");
		
		
		//printing data as html
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><body>");
		out.println("<h1>"+firstName+"</h1>");
		out.println("<h1>"+lastName+"</h1>");
		out.println("<h1>"+dob_raw+"</h1>");
		out.println("<h1>"+gender+"</h1>");
		out.println("</body></html>");
	}

}
