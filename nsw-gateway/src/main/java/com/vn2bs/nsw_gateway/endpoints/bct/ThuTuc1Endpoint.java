package com.vn2bs.nsw_gateway.endpoints.bct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.vn2bs.nsw_gateway.services.bct.ThuTuc1Service;
import com.vn2bs.nsw_gateway.xsd.bct.thutuc1.TraLoiRequest;
import com.vn2bs.nsw_gateway.xsd.bct.thutuc1.TraLoiResponse;

import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class ThuTuc1Endpoint {

    @Autowired
    private ThuTuc1Service thuTuc1Service;

    @PayloadRoot(namespace = "thutuc1.bct.xsd.nsw_gateway.vn2bs.com", localPart = "TraLoiRequest")
    @ResponsePayload
    public TraLoiResponse traLoi(@RequestPayload TraLoiRequest request) {
        log.info("traLoi request={}", request);
        return thuTuc1Service.traLoi(request);
    }
}
