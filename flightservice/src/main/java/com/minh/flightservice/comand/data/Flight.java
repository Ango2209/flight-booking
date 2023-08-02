package com.minh.flightservice.comand.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Document(collection = "flights")
public class Flight implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2353487604236678642L;
	@MongoId
    @Indexed
    private String flightId;
    @Indexed
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    @Indexed
    private String origin;
    @Indexed
    private String destination;
    private String flightNumber;
    private int capacity;
    @JsonManagedReference
    private Set<Seat> seats = new HashSet<Seat>();

    // Constructors

    // Getters and Setters
    public String getFlightId() {
        return flightId;
    }

    public Flight(String flightId, LocalDate departureDate, LocalDate arrivalDate, String origin, String destination,
            String flightNumber, int capacity, int availableSeats, Set<Seat> seat) {
        super();
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.seats = seat;
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
        return seats;
    }

    public void setSeat(Set<Seat> seat) {
        this.seats = seat;
    }

    public Flight() {

    }
}