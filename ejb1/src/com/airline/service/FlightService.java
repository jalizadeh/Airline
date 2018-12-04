package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean // it can be ONLY accessed on the local system, not from other computers over internet
public class FlightService {

	private int id;
	private String from;
	private String to;
	private Integer price;
	private Integer numOfSeats;
	private String airplaneModel;

	/**
	 * Default constructor.
	 */
	public FlightService() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public String getAirplaneModel() {
		return airplaneModel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public void setAirplaneModel(String airplaneModel) {
		this.airplaneModel = airplaneModel;
	}

	@Override
	public String toString() {
		return "FlightService [id=" + id + ", from=" + from + ", to=" + to + ", price=" + price + ", numOfSeats="
				+ numOfSeats + ", airplaneModel=" + airplaneModel + "]";
	}

}
