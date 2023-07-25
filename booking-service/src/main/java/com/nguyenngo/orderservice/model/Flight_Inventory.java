package com.nguyenngo.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@IdClass(FlightInventoryId.class)
@NoArgsConstructor
@AllArgsConstructor
public class Flight_Inventory  {
    @Id
    private Long flight_id;
    @Id
    private String flight_type_id;
    @Id
    private LocalDate date;
    private int total_inventory;
    private int total_reserved;
}
