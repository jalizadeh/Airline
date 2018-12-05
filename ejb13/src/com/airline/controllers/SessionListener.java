package com.airline.controllers;

import javax.ejb.EJB;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.airline.service.CounterStatefulBean;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	
	@EJB
	private CounterStatefulBean cbStateful;
	
    /**
     * Default constructor. 
     */
    public SessionListener() {
    	//System.out.println("public SessionListener()");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         //System.out.println("public void sessionCreated(HttpSessionEvent se)");
         //System.out.println(se.getSession().getId());
         
         HttpSession session = se.getSession();
         session.setAttribute("cbStateful", cbStateful);        
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         //System.out.println("public void sessionDestroyed(HttpSessionEvent se)");
         //System.out.println(se.getSession().getId());
    }
	
}
