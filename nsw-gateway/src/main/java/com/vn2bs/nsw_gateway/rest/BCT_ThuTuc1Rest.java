package com.vn2bs.nsw_gateway.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vn2bs.common.dto.ResponseFactory;
import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;
import com.vn2bs.nsw_gateway.services.BCTMessageHandler;

import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("bct/thu-tuc-1")
@Slf4j
@Tags(value = { @io.swagger.v3.oas.annotations.tags.Tag(name = "BCT ThuTuc1") })
public class BCT_ThuTuc1Rest {

    @Autowired
    private BCTMessageHandler bctMessageHandler;

    @Autowired
    private ResponseFactory responseFactory;

    @PostMapping("tra-loi")
    public ResponseEntity<?> traLoi(@RequestPart(name = "thongTin") TraLoiDto thongTin,
            @RequestPart(required = false) MultipartFile vanBan,
            @RequestPart(required = false) List<MultipartFile> tepDinhKem) throws InvalidKeyException,
            ErrorResponseException, InsufficientDataException, InternalException, InvalidResponseException,
            NoSuchAlgorithmException, ServerException, XmlParserException, IllegalArgumentException, IOException {
        log.info("BCT_ThuTuc1Rest - traLoi: {} {} {}", thongTin, vanBan.getOriginalFilename(),
                tepDinhKem.stream().map(e -> e.getOriginalFilename()).reduce((a, b) -> a + "," + b).orElse(""));
        bctMessageHandler.ThuTuc1_TraLoi(thongTin, vanBan, tepDinhKem);
        return responseFactory.success("Ok");
    }

}
