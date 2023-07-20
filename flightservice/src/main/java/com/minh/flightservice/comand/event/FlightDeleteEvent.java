package com.minh.flightservice.comand.event;

public class FlightDeleteEvent {
    private String flightId;

	public FlightDeleteEvent(String flightId) {
		this.flightId=flightId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	
	
}
