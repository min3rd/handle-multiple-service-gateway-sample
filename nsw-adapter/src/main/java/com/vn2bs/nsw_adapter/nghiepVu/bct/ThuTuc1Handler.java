package com.vn2bs.nsw_adapter.nghiepVu.bct;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.vn2bs.common.config.GlobalConfig;
import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ThuTuc1Handler {

    private final Gson gson = new Gson();

    @KafkaListener(topics = GlobalConfig.Kafka.Topic.BCT.ThuTuc1.TRA_LOI_WS, groupId = "bct", containerFactory = "kafkaListenerContainerFactory")
    public void traLoi(String request) {
        TraLoiDto dto = gson.fromJson(request, TraLoiDto.class);
        log.info("Nhận dữ liệu trả lời thủ tục 1 tại Adapter: (mã hồ sơ={}, kết quả={})", dto.getMaSoHoSo(),
                dto.getKetQua());

    }
}
