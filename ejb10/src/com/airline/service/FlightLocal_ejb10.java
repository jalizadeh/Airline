package com.airline.service;

import javax.ejb.Local;

@Local
public interface FlightLocal_ejb10 {

	public int getId();

	public String getFrom();

	public String getTo();

	public Integer getPrice();

	public Integer getNumOfSeats();

	public String getAirplaneModel();

	public void setId(int id);

	public void setFrom(String from);

	public void setTo(String to);

	public void setPrice(Integer price);

	public void setNumOfSeats(Integer numOfSeats);

	public void setAirplaneModel(String airplaneModel);

	public String toString();
}
