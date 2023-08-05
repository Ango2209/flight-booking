package com.minh.flightservice.query.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minh.flightservice.comand.data.Flight;
import com.minh.flightservice.comand.data.FlightRespository;
import com.minh.flightservice.query.model.FlightResponeModel;
import com.minh.flightservice.query.queries.SearchByID;
import com.minh.flightservice.query.queries.SearchFlight;
import com.minh.flightservice.query.queries.SearchOneFlight;



@RestController
@RequestMapping("/api/v1/flights")
public class FlightQueryController {
	@Autowired
	private QueryGateway queryGateway;
	@Autowired MongoTemplate mongoTemplate;
	
	@Autowired
	private FlightRespository flightRespository;
	@GetMapping("/{from}/{to}/{date}")
	public List<FlightResponeModel> search(@PathVariable String from,@PathVariable String to, @PathVariable LocalDate date) {
		System.out.println(date);
		SearchFlight searchFlight=new SearchFlight(date, from, to);
		List<FlightResponeModel> flightResponeModel=queryGateway.query(searchFlight,ResponseTypes.multipleInstancesOf(FlightResponeModel.class)).join();
		return flightResponeModel;
	}
	@GetMapping("/all")
	public List<FlightResponeModel> searchAll(){
		List<Flight> flight=mongoTemplate.findAll(Flight.class);
		List<FlightResponeModel> flightResponeModels=new ArrayList<FlightResponeModel>();
		flight.forEach(n->{
			FlightResponeModel flightResponeModel=new FlightResponeModel();
			flightResponeModel.setArrivalDate(n.getArrivalDate());
			flightResponeModel.setCapacity(n.getCapacity());
			flightResponeModel.setDepartureDate(n.getDepartureDate());
			flightResponeModel.setDestination(n.getDestination());
			flightResponeModel.setFlightId(n.getFlightId());
			flightResponeModel.setFlightNumber(n.getFlightNumber());
			flightResponeModel.setOrigin(n.getOrigin());
			flightResponeModel.setSeat(n.getSeat());
			flightResponeModels.add(flightResponeModel);
		});
		return flightResponeModels;
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