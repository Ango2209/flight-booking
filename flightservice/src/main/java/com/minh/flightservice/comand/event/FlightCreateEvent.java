package com.minh.flightservice.comand.event;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.minh.flightservice.comand.data.Seat;

public class FlightCreateEvent {
	 private String flightId;
	    private LocalDate departureDate;
	    private LocalDate arrivalDate;
	    private String origin;
	    private String destination;
	    private String flightNumber;
	    private int capacity;
	    private Set<Seat> seat = new HashSet<Seat>();

	    // Constructors

	    // Getters and Setters
	    public String getFlightId() {
	        return flightId;
	    }

	    public FlightCreateEvent(String flightId, LocalDate departureDate, LocalDate arrivalDate, String origin, String destination,
	            String flightNumber, int capacity, int availableSeats, Set<Seat> seats) {
	        super();
	        this.flightId = flightId;
	        this.departureDate = departureDate;
	        this.arrivalDate = arrivalDate;
	        this.origin = origin;
	        this.destination = destination;
	        this.flightNumber = flightNumber;
	        this.capacity = capacity;
	        this.seat = seats;
	    }

	    public FlightCreateEvent() {
			// TODO Auto-generated constructor stub
	    	this.seat = new HashSet<>();
		}

		public void setFlightId(String flightId) {
	        this.flightId = flightId;
	    }

	    public LocalDate getDepartureDate() {
	        return departureDate;
	    }

	    public void setDepartureDate(LocalDate departureDate) {
	        this.departureDate = departureDate;
	    }

	    public LocalDate getArrivalDate() {
	        return arrivalDate;
	    }

	    public void setArrivalDate(LocalDate arrivalDate) {
	        this.arrivalDate = arrivalDate;
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

	    public String getFlightNumber() {
	        return flightNumber;
	    }

	    public void setFlightNumber(String flightNumber) {
	        this.flightNumber = flightNumber;
	    }

	    public int getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }
	    public Set<Seat> getSeat() {
			return seat;
		}

		public void setSeat(Set<Seat> seat) {
			this.seat = seat;
		}
}
