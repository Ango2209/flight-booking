package com.minh.flightservice.comand.aggregate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.minh.flightservice.comand.comand.CreateFlightComand;
import com.minh.flightservice.comand.comand.DeleteFlightComand;
import com.minh.flightservice.comand.comand.UpdateFlightComand;
import com.minh.flightservice.comand.data.Seat;
import com.minh.flightservice.comand.event.FlightCreateEvent;
import com.minh.flightservice.comand.event.FlightDeleteEvent;
import com.minh.flightservice.comand.event.FlightUpdateEvent;


@Aggregate
public class FlightAggregate {
	@AggregateIdentifier
	
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

    public FlightAggregate(String flightId, LocalDate departureDate, LocalDate arrivalDate, String origin, String destination,
            String flightNumber, int capacity, int availableSeats, Set<Seat> seat) {
        super();
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.seat = seat;
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

 

  
	@CommandHandler
	public FlightAggregate(CreateFlightComand createFlightComand) {
		FlightCreateEvent flightCreatedEvent=new FlightCreateEvent();
		BeanUtils.copyProperties(createFlightComand, flightCreatedEvent);
		AggregateLifecycle.apply(flightCreatedEvent);
		
	}
	@CommandHandler
	public void handle(UpdateFlightComand updateFlightComand) {
		FlightUpdateEvent flightUpdateEvent =new FlightUpdateEvent();
		BeanUtils.copyProperties(updateFlightComand, flightUpdateEvent);
		AggregateLifecycle.apply(flightUpdateEvent);
	}
	@CommandHandler
	public void handle(DeleteFlightComand deleteBookCommand) {
		FlightDeleteEvent flightDeleteEvent =new FlightDeleteEvent(deleteBookCommand.getFlightId());
	
		AggregateLifecycle.apply(flightDeleteEvent);
	}
	
	@EventSourcingHandler
	public void on(FlightCreateEvent event) {
		this.origin=event.getOrigin();
		this.capacity=event.getCapacity();
		this.arrivalDate=event.getArrivalDate();
		this.departureDate=event.getDepartureDate();
		this.destination=event.getDestination();
		this.flightId=event.getFlightId();
		this.flightNumber=event.getFlightNumber();
		this.setSeat(event.getSeat());
	}
	@EventSourcingHandler
	public void on(FlightUpdateEvent event) {
		this.origin=event.getOrigin();
		this.capacity=event.getCapacity();
		this.arrivalDate=event.getArrivalDate();
		this.departureDate=event.getDepartureDate();
		this.destination=event.getDestination();
		this.flightId=event.getFlightId();
		this.flightNumber=event.getFlightNumber();
		this.setSeat(event.getSeat());
	}
	@EventSourcingHandler
	public void on(FlightDeleteEvent event) {
		this.flightId=event.getFlightId();
	}

	
}
