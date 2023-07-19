package com.minh.flightservice.query.projection;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minh.flightservice.comand.data.Flight;
import com.minh.flightservice.comand.data.FlightRespository;
import com.minh.flightservice.query.model.FlightResponeModel;
import com.minh.flightservice.query.queries.SearchFlight;

@Component
public class FlightProjection {

	@Autowired
	private FlightRespository flightRespository;

	@QueryHandler
	public List<FlightResponeModel> handle(SearchFlight searchFlight) {

		List<Flight> flightList = flightRespository.findByDateAndDestinationAndOrigin(searchFlight.getDepartureDate(),
				searchFlight.getDestination(), searchFlight.getOrigin());
		System.out.println(flightList.get(0).getSeat().size());
		List<FlightResponeModel> responseModelList = flightList.stream().map(flight -> {
			FlightResponeModel responseModel = new FlightResponeModel();
			BeanUtils.copyProperties(flight, responseModel);
			return responseModel;
		}).collect(Collectors.toList());
		return responseModelList;

	}

}
