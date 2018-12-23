package com.airline.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pilot
 *
 */

@NamedQuery(name = "Pilot.findById", query="SELECT p FROM Pilot p WHERE p.id = :id")
@Entity
public class Pilot implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Pilot() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;   
	
	private String firstName;
	
	private String lastName;
	
	private Integer pilotLicense;
	
	@Enumerated(EnumType.STRING)
	private PilotRank pilotRank;
	
	@ManyToOne
	@JoinColumn(name = "flight_fk")
	private Flight flightForPilot;

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getPilotLicense() {
		return pilotLicense;
	}

	public PilotRank getPilotRank() {
		return pilotRank;
	}

	public Flight getFlightForPilot() {
		return flightForPilot;
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

	public void setPilotLicense(Integer pilotLicense) {
		this.pilotLicense = pilotLicense;
	}

	public void setPilotRank(PilotRank pilotRank) {
		this.pilotRank = pilotRank;
	}

	public void setFlightForPilot(Flight flightForPilot) {
		this.flightForPilot = flightForPilot;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pilotLicense="
				+ pilotLicense + ", pilotRank=" + pilotRank + ", flightForPilot=" + flightForPilot + "]";
	}
}
