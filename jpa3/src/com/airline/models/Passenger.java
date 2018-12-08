package com.airline.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Passenger
 *
 */
@Entity

public class Passenger implements Serializable {

	// ignore this property & don`t create any column in DB for this
	@Transient
	private static final long serialVersionUID = 1L;

	public Passenger() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}
