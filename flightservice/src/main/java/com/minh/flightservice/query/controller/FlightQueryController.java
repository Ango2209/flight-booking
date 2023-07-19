package com.minh.flightservice.query.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.minh.flightservice.query.model.FlightResponeModel;
import com.minh.flightservice.query.queries.SearchFlight;



@RestController
@RequestMapping("/api/v1/flights")
public class FlightQueryController {
	@Autowired
	private QueryGateway queryGateway;
	@GetMapping("/{from}/{to}/{date}")
	public List<FlightResponeModel> search(@PathVariable String from,@PathVariable String to, @PathVariable LocalDate date) {
		SearchFlight searchFlight=new SearchFlight(date, from, to);
		List<FlightResponeModel> flightResponeModel=queryGateway.query(searchFlight,ResponseTypes.multipleInstancesOf(FlightResponeModel.class)).join();
		return flightResponeModel;
	}
}