package com.jalizadeh.airline.models;

import java.util.Date;

public class Passenger {
	private String firstName;
	private String lastName;
	private Date dao;
	private Gender gender;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getDao() {
		return dao;
	}
	public Gender getGender() {
		return gender;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDao(Date dao) {
		this.dao = dao;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", dao=" + dao + ", gender=" + gender
				+ "]";
	}
}
