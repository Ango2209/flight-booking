package com.minh.flightservice.query.queries;

import java.sql.Date;
import java.time.LocalDate;




public class SearchFlight {
	private LocalDate  departureDate;
	private String origin;
	private String destination;
	

	// Constructors

	// Getters and Setters


	public SearchFlight(LocalDate departureDate, String origin, String destination) {
		
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
