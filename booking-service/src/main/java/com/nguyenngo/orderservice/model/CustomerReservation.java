package com.nguyenngo.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String CCCD;
    private String email;


    public CustomerReservation(String name, String CCCD, String email) {
        this.name = name;
        this.CCCD = CCCD;
        this.email = email;
    }
}
