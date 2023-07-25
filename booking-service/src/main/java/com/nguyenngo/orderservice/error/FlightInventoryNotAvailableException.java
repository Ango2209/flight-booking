package com.nguyenngo.orderservice.error;

public class FlightInventoryNotAvailableException extends RuntimeException{
    public FlightInventoryNotAvailableException(String message) {
        super(message);
    }
}
