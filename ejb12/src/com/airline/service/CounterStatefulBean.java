package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CounterBean
 */
@Stateful
@LocalBean
public class CounterStatefulBean {

	private int count;

	/**
	 * Default constructor.
	 */
	public CounterStatefulBean() {
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
