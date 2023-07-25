package com.nguyenngo.orderservice.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

public class FlightInventoryId implements Serializable {
    @Id
    private Long flight_id;
    @Id

    private String flight_type_id;
    @Id
    private LocalDate date;

    public FlightInventoryId() {

    }

    public FlightInventoryId(Long flight_id, String flight_type_id, LocalDate date) {
        this.flight_id = flight_id;
        this.flight_type_id = flight_type_id;
        this.date = date;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_type_id() {
        return flight_type_id;
    }

    public void setFlight_type_id(String flight_type_id) {
        this.flight_type_id = flight_type_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FlightInventoryId{" +
                "flight_id=" + flight_id +
                ", flight_type_id='" + flight_type_id + '\'' +
                ", date=" + date +
                '}';
    }
}
