package com.nguyenngo.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private Long flight_id;
    private String name;
    private String CCCD;
    private String email;
}
