package com.jalizadeh.airline.controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jalizadeh.airline.models.Passenger;

/**
 * Application Lifecycle Listener implementation class AirlineListener
 *
 */
@WebListener
public class AirlineListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AirlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * This listener will create an empty list to be filled by the passengers 
     * from the form
     */
    public void contextDestroyed(ServletContextEvent event)  { 
	    ServletContext sc = event.getServletContext();
	     
	    ArrayList<Passenger> pList = (ArrayList<Passenger>) sc.getAttribute("passengers");
	    if(pList == null ) {
	    	System.out.println("There is no list of passengers, let`s create one");
	    	 
	    	pList = new ArrayList<>();
	    	sc.setAttribute("passengers", pList);
	    }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
