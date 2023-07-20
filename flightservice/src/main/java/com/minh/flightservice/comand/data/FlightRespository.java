package com.minh.flightservice.comand.data;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface FlightRespository extends MongoRepository<Flight,String> {
	@Query(value = "{ 'departureDate': ?0, 'destination': ?1, 'origin': ?2 }")
	List<Flight> findByDateAndDestinationAndOrigin(LocalDate departureDate, String destination, String origin);
}
