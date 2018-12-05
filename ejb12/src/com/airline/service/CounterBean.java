package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class CounterBean
 */
@Singleton
@LocalBean
public class CounterBean {

	private int count;

	/**
	 * Default constructor.
	 */
	public CounterBean() {
		// TODO Auto-generated constructor stub
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addOne() {
		this.count += 1;
	}

}
