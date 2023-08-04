package com.nguyenngo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.util.StringUtils;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent event){
        String toEmail= event.getEmail();
        if ( toEmail!=null &&!toEmail.isEmpty()){
            emailSenderService.sendEmail("20115331.ngo@student.iuh.edu.vn", "Test email","Bạn đã đặt vé thành công");
            log.info("Received Notification for Order- {}",event.getOrderNumber());
        }
       // send out an email notification

    }
}
