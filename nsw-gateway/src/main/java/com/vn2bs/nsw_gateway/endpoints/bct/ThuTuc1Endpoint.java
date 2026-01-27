package com.vn2bs.nsw_gateway.endpoints.bct;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.vn2bs.nsw_gateway.xsd.bct.thutuc1.TraLoiRequest;
import com.vn2bs.nsw_gateway.xsd.bct.thutuc1.TraLoiResponse;

import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class ThuTuc1Endpoint {
    @PayloadRoot(namespace = "thutuc1.bct.xsd.nsw_gateway.vn2bs.com", localPart = "TraLoiRequest")
    @ResponsePayload
    public TraLoiResponse traLoi(@RequestPayload TraLoiRequest request) {
        log.info("traLoi request={}", request);
        TraLoiResponse response = new TraLoiResponse();
        // Set response fields as needed
        return response;

    }
}
