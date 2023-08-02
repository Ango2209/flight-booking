package com.minh.flightservice.query.queries;

import java.time.LocalDate;

public class SearchOneFlight {
	private LocalDate  departureDate;
	private String origin;
	private String destination;
	

	// Constructors

	// Getters and Setters


	public SearchOneFlight(LocalDate departureDate, String origin, String destination) {
		super();
		this.departureDate = departureDate;
		this.origin = origin;
		this.destination= destination;
	}

	
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
