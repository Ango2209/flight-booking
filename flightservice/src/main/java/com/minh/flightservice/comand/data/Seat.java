package com.minh.flightservice.comand.data;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Document(collection = "seats")
public class Seat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7748764549693106866L;
	@MongoId
	private int seatId;
	@DBRef
	@JsonBackReference
	private Flight flight;
	private String seatNumber;
	private String seatClass;
	private double price;
	private boolean status;

	// Constructors
	public Seat(int seatId, Flight flightId, String seatNumber, String seatClass, double price) {
		this.seatId = seatId;
		this.flight = flightId;
		this.seatNumber = seatNumber;
		this.seatClass = seatClass;
		this.price = price;
	}
	
	public Seat(int seatId, Flight flight, String seatNumber, String seatClass, double price, boolean status) {
		super();
		this.seatId = seatId;
		this.flight = flight;
		this.seatNumber = seatNumber;
		this.seatClass = seatClass;
		this.price = price;
		this.status = status;
	}

	public Seat() {
		
	}

	// Getters and Setters
	

	
	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
}
