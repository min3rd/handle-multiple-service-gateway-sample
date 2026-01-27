package com.vn2bs.nsw_gateway.endpoints.bct;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import lombok.extern.slf4j.Slf4j;
import thutuc1.bct.webservices.vn2bs.com.TraLoiRequest;
import thutuc1.bct.webservices.vn2bs.com.TraLoiResponse;

@Endpoint
@Slf4j
public class ThuTuc1Endpoint {
    @PayloadRoot(namespace = "com.vn2bs.webservices.bct.thutuc1", localPart = "TraLoiRequest")
    @ResponsePayload
    public TraLoiResponse traLoi(@RequestPayload TraLoiRequest request) {
        log.info("traLoi request={}", request);
        TraLoiResponse response = new TraLoiResponse();
        // Set response fields as needed
        return response;

    }
}
