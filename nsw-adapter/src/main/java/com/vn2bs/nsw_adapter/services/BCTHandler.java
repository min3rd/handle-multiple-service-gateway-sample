package com.vn2bs.nsw_adapter.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BCTHandler {
    @KafkaListener(topics = "bct-topic", groupId = "bct")
    public void handleBCTMessage(String message) {
        // Handle the message
        System.out.println("Received message in BCTHandler: " + message);
    }
}
