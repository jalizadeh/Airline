package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Passenger
 *
 */

@Entity
@XmlRootElement
public class Passenger implements Serializable {

	// ignore this property & don`t create any column in DB for this
	@Transient
	private static final long serialVersionUID = 1L;

	public Passenger() {
		super();
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) it seems it causes error
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String firstName;
	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date dob;

	// if we don`t use this annotation, the enums will be stored as digits, starting from 0,...
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private FlightClass flightClass;
	
	@ManyToMany(mappedBy = "passengers")
	private List<Flight> flights;

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDob() {
		return dob;
	}

	public Gender getGender() {
		return gender;
	}

	public FlightClass getFlightClass() {
		return flightClass;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setFlightClass(FlightClass flightClass) {
		this.flightClass = flightClass;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", flightClass=" + flightClass + "]";
	}
}
