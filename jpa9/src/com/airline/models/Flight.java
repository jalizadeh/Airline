package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */

@NamedQuery(name="Flight.findById", query="SELECT f FROM Flight f WHERE f.id = :id")
@Entity
public class Flight implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Flight() {
		super();
	}
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightOrigin;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightDestination;
	
	private Integer price;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date flightTime;
	
	@OneToOne
	@JoinColumn(name = "airplane_fk")
	private Airplane airplaneDetail;
	
	@OneToMany(mappedBy = "flightForPilot")
	private List<Pilot> pilots;

	public Integer getId() {
		return id;
	}

	public FlightDestinations getFlightOrigin() {
		return flightOrigin;
	}

	public FlightDestinations getFlightDestination() {
		return flightDestination;
	}

	public Integer getPrice() {
		return price;
	}

	public Date getFlightTime() {
		return flightTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFlightOrigin(FlightDestinations flightOrigin) {
		this.flightOrigin = flightOrigin;
	}

	public void setFlightDestination(FlightDestinations flightDestination) {
		this.flightDestination = flightDestination;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}
	
	public Airplane getAirplaneDetail() {
		return airplaneDetail;
	}

	public void setAirplaneDetail(Airplane airplaneDetail) {
		this.airplaneDetail = airplaneDetail;
	}
	
	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightOrigin=" + flightOrigin + ", flightDestination=" + flightDestination
				+ ", price=" + price + ", flightTime=" + flightTime + ", airplaneDetail=" + airplaneDetail + ", pilots="
				+ pilots + "]";
	}
}
