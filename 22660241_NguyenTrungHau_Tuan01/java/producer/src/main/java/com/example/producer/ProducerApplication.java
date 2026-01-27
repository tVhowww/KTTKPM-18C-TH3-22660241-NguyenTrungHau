package com.example.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class ProducerApplication {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @PostMapping("/send")
    public Map<String, Object> send(@RequestBody Map<String, String> body) {
        String message = body.get("message");
        String orderId = body.get("orderId");

        if (message == null || orderId == null) {
            throw new RuntimeException("Thieu message hoac orderId");
        }

        Map<String, Object> data = new HashMap<>();
        data.put("message", message);
        data.put("orderId", orderId);
        data.put("timestamp", new Date());

        // Gửi tin nhắn vào Queue
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, data);
        System.out.println("DA GUI: " + data);

        return Map.of("status", "success", "data", data);
    }
}