package com.minh.flightservice.query.controller;

import java.time.LocalDate;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minh.flightservice.query.model.FlightResponeModel;
import com.minh.flightservice.query.queries.SearchByID;
import com.minh.flightservice.query.queries.SearchFlight;
import com.minh.flightservice.query.queries.SearchOneFlight;



@RestController
@RequestMapping("/api/v1/flights")
public class FlightQueryController {
	@Autowired
	private QueryGateway queryGateway;
	@GetMapping("/{from}/{to}/{date}")
	public List<FlightResponeModel> search(@PathVariable String from,@PathVariable String to, @PathVariable LocalDate date) {
		System.out.println(date);
		SearchFlight searchFlight=new SearchFlight(date, from, to);
		List<FlightResponeModel> flightResponeModel=queryGateway.query(searchFlight,ResponseTypes.multipleInstancesOf(FlightResponeModel.class)).join();
		return flightResponeModel;
	}
	@GetMapping("/only/{from}/{to}/{date}")
	public FlightResponeModel searchOneFlight(@PathVariable String from,@PathVariable String to, @PathVariable LocalDate date) {
		System.out.println(date);
		SearchOneFlight searchOneFlight=new SearchOneFlight(date, from, to);
		FlightResponeModel flightResponeModel=queryGateway.query(searchOneFlight,ResponseTypes.instanceOf(FlightResponeModel.class)).join();
		return flightResponeModel;
	}
	@GetMapping("/{id}")
	public FlightResponeModel searchByID(@PathVariable String id) {
		SearchByID seachByID=new SearchByID(id);
		FlightResponeModel flightResponeModel=queryGateway.query(seachByID,ResponseTypes.instanceOf(FlightResponeModel.class)).join();
		return flightResponeModel;
	}
	
}