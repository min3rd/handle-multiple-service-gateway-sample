package com.vn2bs.nsw_adapter.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;
import com.vn2bs.nsw_adapter.services.BCTMessageHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("bct/thu-tuc-1")
public class BCT_ThuTuc1Rest {

    @Autowired
    private BCTMessageHandler bctMessageHandler;

    @PostMapping("tra-loi")
    public String traLoi(@RequestBody TraLoiDto dto) {
        bctMessageHandler.ThuTuc1_TraLoi(dto);
        return "OK";
    }

}
