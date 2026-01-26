package com.vn2bs.nsw_adapter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vn2bs.common.domains.ThuTuc1.ThuTuc1_TraLoi;
import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;
import com.vn2bs.common.repositories.ThuTuc1.ThuTuc1_TraLoiRepository;
import com.vn2bs.nsw_adapter.mapper.ThuTuc1.TraLoiMapper;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BCTMessageHandler {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private ThuTuc1_TraLoiRepository traLoiRepository;

    @Autowired
    private TraLoiMapper traLoiMapper;

    public void ThuTuc1_TraLoi(TraLoiDto message) {
        log.info("Processing TraLoi message: {}", message);

        ThuTuc1_TraLoi entity = traLoiMapper.toEntity(message);

        entity = traLoiRepository.save(entity);
        log.info("Saved TraLoi entity: {}", entity);
    }
}
