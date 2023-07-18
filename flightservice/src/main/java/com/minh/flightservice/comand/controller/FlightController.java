package com.minh.flightservice.comand.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minh.flightservice.comand.comand.CreateFlightComand;
import com.minh.flightservice.comand.comand.DeleteFlightComand;
import com.minh.flightservice.comand.comand.UpdateFlightComand;
import com.minh.flightservice.comand.model.FlightRequestModel;
@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
	@Autowired
	private CommandGateway commandGateway;

	@PostMapping
	public String addFlight(@RequestBody FlightRequestModel model) {
		CreateFlightComand createFlightComand = new CreateFlightComand(UUID.randomUUID().toString(),
				model.getDepartureDate(), model.getArrivalDate(), model.getOrigin(), model.getDestination(),
				model.getFlightNumber(), model.getCapacity(), model.getSeat());
		commandGateway.sendAndWait(createFlightComand);
		return "added Flight";
	}

	@PutMapping
	public String updateFlight(@RequestBody FlightRequestModel flightResquestModel) {
		UpdateFlightComand updateFlightCommand = new UpdateFlightComand(flightResquestModel.getFlightNumber(),
				flightResquestModel.getDepartureDate(), flightResquestModel.getArrivalDate(),
				flightResquestModel.getOrigin(), flightResquestModel.getDestination(),
				flightResquestModel.getFlightNumber(), flightResquestModel.getCapacity(),
				flightResquestModel.getSeat());
		commandGateway.sendAndWait(updateFlightCommand);
		return "updated flight";
	}

	@DeleteMapping("/{flightID}")
	public String deleteFlight(@PathVariable String flightID) {
		DeleteFlightComand deleteFlightComand = new DeleteFlightComand(flightID);
		commandGateway.sendAndWait(deleteFlightComand);
		return "deleted Book";
	}
}