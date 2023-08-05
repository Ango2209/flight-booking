package com.minh.flightservice.comand.event;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.minh.flightservice.comand.data.Flight;
import com.minh.flightservice.comand.data.FlightRespository;
import com.minh.flightservice.comand.data.Seat;

@Component
public class FlightEventHandler {
	@Autowired
	private FlightRespository flightRespository;
	
	@Autowired MongoTemplate mongoTemplate;

	@EventHandler
	public void on(FlightCreateEvent event) {
		Flight flight = new Flight();
		System.out.println(event.getSeat());
		BeanUtils.copyProperties(event, flight);
		Set<Seat> seats = event.getSeat();
		if (seats == null) {
	        seats = new HashSet<>();
	    }

	    seats.forEach(n -> {
	        n.setFlight(flight);
	    });
		flight.setSeat(seats);
		mongoTemplate.save(flight);
	}

	@EventHandler
	public void on(FlightUpdateEvent event) {
		Optional<Flight> flightOptionalFlight = flightRespository.findById(event.getFlightId());
		if (flightOptionalFlight.isPresent()) {
		    Flight flight = flightOptionalFlight.get();
		    flight.setArrivalDate(event.getArrivalDate());
		    flight.setCapacity(event.getCapacity());
		    flight.setDepartureDate(event.getDepartureDate());
		    flight.setDestination(event.getDestination());
		    flight.setFlightId(event.getFlightId());
		    flight.setFlightNumber(event.getFlightNumber());
		    flight.setOrigin(event.getOrigin());
		    flight.setSeat(event.getSeats());
		    flightRespository.save(flight);
		} else {
		    // Xử lý trường hợp không tìm thấy chuyến bay (flight) bằng notify service
			
		}
		
	}

	@EventHandler
	public void on(FlightDeleteEvent event) {
		flightRespository.deleteById(event.getFlightId());

	}
}
