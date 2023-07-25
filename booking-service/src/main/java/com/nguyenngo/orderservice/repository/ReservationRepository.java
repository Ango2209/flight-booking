package com.nguyenngo.orderservice.repository;

import com.nguyenngo.orderservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
