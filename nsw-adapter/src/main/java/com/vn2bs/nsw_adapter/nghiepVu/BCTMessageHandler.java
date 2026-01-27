package com.vn2bs.nsw_adapter.nghiepVu;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class BCTMessageHandler {
    @KafkaListener(topics = "thu-tuc-1-tra-loi", groupId = "bct")
    public void listen(String message) {
        System.out.println("Received Message in group 'bct': " + message);
    }
}
