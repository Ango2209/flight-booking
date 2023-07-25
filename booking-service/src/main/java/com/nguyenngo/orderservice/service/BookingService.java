package com.nguyenngo.orderservice.service;

import com.nguyenngo.orderservice.dto.BookingRequest;
import com.nguyenngo.orderservice.dto.OrderRequest;
import com.nguyenngo.orderservice.dto.TotalInventory;
import com.nguyenngo.orderservice.error.FlightInventoryNotAvailableException;
import com.nguyenngo.orderservice.event.OrderPlacedEvent;
import com.nguyenngo.orderservice.model.CustomerReservation;
import com.nguyenngo.orderservice.model.FlightInventoryId;
import com.nguyenngo.orderservice.model.Flight_Inventory;
import com.nguyenngo.orderservice.model.Reservation;
import com.nguyenngo.orderservice.repository.CustomerReservationRepository;
import com.nguyenngo.orderservice.repository.FlightInventoryRepository;

import com.nguyenngo.orderservice.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingService {
    private final FlightInventoryRepository flightInventoryRepository;
    private final ReservationRepository reservationRepository;
    private final CustomerReservationRepository customerReservationRepository;
    private final WebClient.Builder webClientBuilder;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    @Autowired
    private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
    @Transactional
    public void placeOrder(BookingRequest bookingRequest) {


        Flight_Inventory inventory= flightInventoryRepository.findByFlightId(bookingRequest.getFlight_id());
        if (inventory !=null && inventory.getTotal_inventory()>0&&EMAIL_PATTERN.matcher(bookingRequest.getEmail()).matches()){
            Reservation reservation=new Reservation(inventory.getFlight_type_id(),inventory.getFlight_id(),"Da dat");
            CustomerReservation customerReservation=new CustomerReservation( bookingRequest.getName(),bookingRequest.getEmail(),bookingRequest.getEmail());
            reservation.setCustomerReservation(customerReservation);
            reservationRepository.save(reservation);
            customerReservationRepository.save(customerReservation);
                kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(reservation.getReservation_id()+"",bookingRequest.getEmail()));
                flightInventoryRepository.decreaseTotalInventory(bookingRequest.getFlight_id());

        }else {
            throw new FlightInventoryNotAvailableException("Flight is not available");
        }



    }

    public void getListOfOrder(){

    }
}
