package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.service.CounterSingletonBean;
import com.airline.service.CounterStatefulBean;

/**
 * Servlet implementation class ShowCount
 */
@WebServlet("/ShowCount")
public class ShowCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CounterSingletonBean cb;
    
	/*
	 * For each session between the application & user (browser)
	 * a "cbStateful" bean will be created dynamically via
	 * "SessionListener"
	 * 
	@EJB
	private CounterStatefulBean cbStateful;
	*/
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CounterStatefulBean cbStateful = (CounterStatefulBean) session.getAttribute("cbStateful");
		
		PrintWriter out = response.getWriter();
		
		out.println("[Singleton] The value of counter is: " + cb.getCount());
		out.println("[Stateful] The value of counter is: " + cbStateful.getCount());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
