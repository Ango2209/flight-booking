package com.nguyenngo.orderservice.controller;

import com.nguyenngo.orderservice.dto.BookingRequest;
import com.nguyenngo.orderservice.dto.OrderRequest;
import com.nguyenngo.orderservice.model.Flight_Inventory;
import com.nguyenngo.orderservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @PostMapping("api/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody BookingRequest bookingRequest){
        bookingService.placeOrder(bookingRequest);
        return "Order Placed Successfully";
    }

}


