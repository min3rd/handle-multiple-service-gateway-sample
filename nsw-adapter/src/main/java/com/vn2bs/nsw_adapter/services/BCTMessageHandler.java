package com.vn2bs.nsw_adapter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;
import com.vn2bs.common.repositories.ThuTuc1.ThuTuc1_TraLoiRepository;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BCTMessageHandler {

    @Autowired
    private MinioClient minioClient;

    private final ThuTuc1_TraLoiRepository thuTuc1_TraLoiRepository;

    public BCTMessageHandler(ThuTuc1_TraLoiRepository thuTuc1_TraLoiRepository) {
        this.thuTuc1_TraLoiRepository = thuTuc1_TraLoiRepository;
    }

    public void ThuTuc1_TraLoi(TraLoiDto message, List<MultipartFile> files) {
        log.info("Processing TraLoi message: {}, files count: {}", message, files.size());
        // Implement your logic to handle the message and files here
    }
}
