package com.nguyenngo.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long reservation_id;

    private String flight_type_id;

    private Long flight_id;
    private String status;
    @OneToOne
    @JoinColumn(name = "customer_reservation_id")
    private CustomerReservation customerReservation;
    public Reservation(String flight_type_id, Long flight_id, String status) {
        this.flight_type_id = flight_type_id;
        this.flight_id = flight_id;
        this.status = status;
    }

}
