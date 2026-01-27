package com.vn2bs.nsw_adapter.nghiepVu;

import org.springframework.stereotype.Component;

import com.vn2bs.common.config.GlobalConfig;
import com.vn2bs.common.domains.ThuTuc1.ThuTuc1_TraLoi;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;

@Component
@Slf4j
public class BCT_ThuTuc1 {
    @KafkaListener(topics = GlobalConfig.Kafka.Topic.BCT.ThuTuc1.TRA_LOI, groupId = "bct", containerFactory = "ThuTuc1_TraLoi_kafkaListenerContainerFactory")
    public void ThuTuc1_TraLoi(ThuTuc1_TraLoi message) {
        log.info("Receive message={}", message);
    }
}
