package com.minh.flightservice.query.projection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.minh.flightservice.comand.data.Flight;
import com.minh.flightservice.comand.data.FlightRespository;
import com.minh.flightservice.query.model.FlightResponeModel;
import com.minh.flightservice.query.queries.SearchByID;
import com.minh.flightservice.query.queries.SearchFlight;
import com.minh.flightservice.query.queries.SearchOneFlight;

@Component
public class FlightProjection {

	@Autowired
	private FlightRespository flightRespository;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	

	@QueryHandler
	public List<FlightResponeModel> handle(SearchFlight searchFlight) {
		//List<Flight> flightList = flightRespository.findByDateAndDestinationAndOrigin(searchFlight.getDepartureDate(),
				
		Query query = new Query();
		
		query.addCriteria(Criteria.where("departureDate").is(searchFlight.getDepartureDate()));
	    query.addCriteria(Criteria.where("destination").is(searchFlight.getDestination()));
	    query.addCriteria(Criteria.where("origin").is(searchFlight.getOrigin()));
		List<Flight> flightList=mongoTemplate.find(query, Flight.class);
		List<FlightResponeModel> flightResponeModels=new ArrayList<FlightResponeModel>();
		flightList.forEach(n->{
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
	@QueryHandler
	public FlightResponeModel handle(SearchOneFlight searchOneFlight) {
		
		List<Flight> flightList = flightRespository.findByDateAndDestinationAndOrigin(searchOneFlight.getDepartureDate(),
				searchOneFlight.getDestination(), searchOneFlight.getOrigin());
	
		List<FlightResponeModel> responseModelList = flightList.stream().map(flight -> {
			FlightResponeModel responseModel = new FlightResponeModel();
			BeanUtils.copyProperties(flight, responseModel);
			return responseModel;
		}).collect(Collectors.toList());
		return responseModelList.get(0);
		
	}
	@QueryHandler
	public FlightResponeModel handle(SearchByID searchByID) {
		Flight flight = flightRespository.findById(searchByID.getId()).orElse(null);
		FlightResponeModel flightResponeModel=new FlightResponeModel();
		BeanUtils.copyProperties(flight, flightResponeModel);
		return flightResponeModel;
		
	}

}
