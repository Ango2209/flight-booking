package com.nguyenngo.orderservice.controller;

import com.nguyenngo.orderservice.dto.BookingRequest;

import com.nguyenngo.orderservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")

public class BookingController {
    private final BookingService bookingService;

    @GetMapping ("/getByUserId/{id}")
    public String getAllOrderById(@PathVariable String id) {

        return "ok";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody BookingRequest bookingRequest){
        bookingService.placeOrder(bookingRequest);
        return "Order Placed Successfully";
    }

}


