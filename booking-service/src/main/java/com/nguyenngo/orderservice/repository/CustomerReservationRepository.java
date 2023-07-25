package com.nguyenngo.orderservice.repository;

import com.nguyenngo.orderservice.model.CustomerReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReservationRepository extends JpaRepository<CustomerReservation,Long> {
}
