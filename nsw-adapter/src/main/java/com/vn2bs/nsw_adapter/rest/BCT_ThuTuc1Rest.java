package com.vn2bs.nsw_adapter.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;
import com.vn2bs.nsw_adapter.services.BCTMessageHandler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("bct/thu-tuc-1")
public class BCT_ThuTuc1Rest {

    @Autowired
    private BCTMessageHandler bctMessageHandler;

    @PostMapping("tra-loi")
    public String traLoi(@RequestBody TraLoiDto entity, List<MultipartFile> files) {
        return "OK";
    }

}
