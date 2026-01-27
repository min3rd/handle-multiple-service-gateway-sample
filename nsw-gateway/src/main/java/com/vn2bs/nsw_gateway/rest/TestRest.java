package com.vn2bs.nsw_gateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.vn2bs.nsw_gateway.services.SendMessageHandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("test")
public class TestRest {
    @Autowired
    private SendMessageHandler sendMessageHandler;

    @GetMapping("send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        sendMessageHandler.sendMessage("test-topic", message);
        return ResponseEntity.ok().body("Message: " + message);
    }

    @KafkaListener(topics = "test-topic", groupId = "test")
    public void listen(String message) {
        System.out.println("Received Message in group 'test': " + message);
    }
}
