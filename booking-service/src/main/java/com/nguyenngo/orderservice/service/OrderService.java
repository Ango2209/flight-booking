package com.nguyenngo.orderservice.service;

import com.nguyenngo.orderservice.dto.OrderRequest;
import com.nguyenngo.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    @Autowired
    private KafkaTemplate<Object, String> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {

        kafkaTemplate.send("notificationTopic", "notify");
        System.out.println("Order successfully");


    }
    public void getListOfOrder(){

    }
}
