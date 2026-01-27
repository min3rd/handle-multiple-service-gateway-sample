package com.vn2bs.nsw_gateway.services;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vn2bs.common.config.GlobalConfig;
import com.vn2bs.common.domains.Status;
import com.vn2bs.common.domains.ThuTuc1.ThuTuc1_TraLoi;
import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;
import com.vn2bs.common.repositories.ThuTuc1.ThuTuc1_TraLoiRepository;
import com.vn2bs.common.utils.NameUtil;
import com.vn2bs.nsw_gateway.mapper.ThuTuc1.TraLoiMapper;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
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

    @Autowired
    private KafkaTemplate<String, ThuTuc1_TraLoi> kafkaTemplate;

    public void ThuTuc1_TraLoi(TraLoiDto message, MultipartFile vanBan, List<MultipartFile> tepDinhKem)
            throws InvalidKeyException, ErrorResponseException, InsufficientDataException, InternalException,
            InvalidResponseException, NoSuchAlgorithmException, ServerException, XmlParserException,
            IllegalArgumentException, IOException {
        log.info("message={} vanBan={} tepDinhKem={}", message, vanBan.getOriginalFilename(),
                tepDinhKem.stream().map(e -> e.getOriginalFilename()).reduce((a, b) -> a + "," + b).orElse(""));

        ThuTuc1_TraLoi entity = traLoiMapper.toEntity(message);

        entity.setStatus(Status.CREATED);

        final String bucketName = NameUtil.toBucketNameSafe("bct-thutuc1-traloi", message.getMaSoHoSo());
        entity.setBucketName(bucketName);
        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder().bucket(bucketName).build());
        }

        if (vanBan != null && !vanBan.isEmpty()) {
            final String vanBanName = NameUtil.toFileNameSafe("vanBan_", vanBan.getOriginalFilename());
            minioClient.putObject(io.minio.PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(vanBanName)
                    .stream(vanBan.getInputStream(), vanBan.getSize(), -1)
                    .contentType(vanBan.getContentType())
                    .build());
            log.info("Uploaded vanBan: {}", vanBan.getOriginalFilename());
            entity.setVanBan(vanBanName);
        }

        if (tepDinhKem != null && tepDinhKem.size() > 0) {
            for (MultipartFile file : tepDinhKem) {
                if (file != null && !file.isEmpty()) {
                    final String fileName = NameUtil.toFileNameSafe("tepDinhKem_", file.getOriginalFilename());
                    minioClient.putObject(io.minio.PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build());
                    log.info("Uploaded tepDinhKem: {}", file.getOriginalFilename());
                    if (entity.getTaiLieuDinhKem() == null) {
                        entity.setTaiLieuDinhKem(new java.util.ArrayList<>());
                    }
                    entity.getTaiLieuDinhKem().add(fileName);
                }
            }
        }
        entity = traLoiRepository.save(entity);
        log.info("Saved TraLoi entity: {}", entity);

        try {
            kafkaTemplate.send(GlobalConfig.Kafka.Topic.BCT.ThuTuc1.TRA_LOI, entity);
        } catch (Exception ex) {
            log.error("Error sending message to Kafka for TraLoi id={} error={}", entity.getId(), ex.getMessage());
        }
    }
}
