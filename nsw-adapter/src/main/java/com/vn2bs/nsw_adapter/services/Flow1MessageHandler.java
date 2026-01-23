package com.vn2bs.nsw_adapter.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Flow1MessageHandler {
    @KafkaListener(topics = "flow1-topic", groupId = "flow1")
    public void handleFlow1Message(String message) {
        // Handle the message
        System.out.println("Received message in Flow1MessageHandler: " + message);
    }
}
