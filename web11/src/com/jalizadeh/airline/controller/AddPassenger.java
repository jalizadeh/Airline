package com.jalizadeh.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jalizadeh.airline.models.Gender;
import com.jalizadeh.airline.models.Passenger;

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
		
		Passenger p = new Passenger();

		//by default, it is false
		request.setAttribute("errors", false);
		
		String firstName = request.getParameter("first-name");
		if(firstName.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);
		} else {
			p.setFirstName(firstName);
		}
		
		String lastName = request.getParameter("last-name");
		if(lastName.length() == 0) {
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);
		} else {
			p.setLastName(lastName);
		}
		
		//setting date of birth 
		String dob_raw = request.getParameter("dob");
		
		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(dob_raw);
		if(m.find()) {
			String[] dobItems = dob_raw.split("\\/");
			String month = dobItems[0];
			String day = dobItems[1];
			String year = dobItems[2];
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			
			Date dob = cal.getTime();
			p.setDao(dob);
		
		} else {
			request.setAttribute("errors", true);
			request.setAttribute("date_format_error", true);
		}
		//----
		
		//in a simple scenario, we assume it is always valid
		//but in fact, it is not :|
		String gender = request.getParameter("gender");
		p.setGender(Gender.valueOf(gender));
		
		//if there is any error, it must be shown and be handled
		if((Boolean) request.getAttribute("errors")) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
			view.forward(request, response);
		
		} else {//everything is OK		
			
			ServletContext sc = this.getServletContext();
			
			
			/**
			 * web 11
			 * this technique will make sure that writing on the pList is
			 * "Thread-Safe", so even if two passenger register at the same
			 * time, they will be put on the list, one after each other
			 * without any problem.
			 */
			synchronized (this) {
				/**
				 * Instead of creating a list every time, we will create it once
				 * and add the new passenger to it
				 * We need a global context named as "ServletContext" which will be
				 * available for the whole project lifetime
				 * 
				 * For the first initialization of the array, we will use a listener
				 * @see AirlineListener
				 */
				//ArrayList<Passenger> pList = new ArrayList<>(); 
				ArrayList<Passenger> pList = (ArrayList<Passenger>) sc.getAttribute("passengers");
				pList.add(p);
				
				sc.setAttribute("passengers", pList);
			}
			
			
			response.sendRedirect("");
			
			/*
			//printing data as html
			//"System.out.println" is not working in my Eclipse, so I use this technique
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<html><body>");
			out.println("<h1>"+firstName+"</h1>");
			out.println("<h1>"+lastName+"</h1>");
			out.println("<h1>"+dob_raw+"</h1>");
			out.println("<h1>"+gender+"</h1>");
			out.println("</body></html>");
			*/
		}
	}

}
