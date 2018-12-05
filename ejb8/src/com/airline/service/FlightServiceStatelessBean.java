package com.airline.service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class FlightService
 */
@Stateless(name = "flightStateless")
public class FlightServiceStatelessBean implements FlightLocal_ejb8{

	private int id = 1111;
	private String from = "Turin";
	private String to = "Roma";
	private Integer price =  179;
	private Integer numOfSeats = 250;
	private String airplaneModel = "Boeing 777";

	/**
	 * Default constructor.
	 */
	public FlightServiceStatelessBean(){
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
