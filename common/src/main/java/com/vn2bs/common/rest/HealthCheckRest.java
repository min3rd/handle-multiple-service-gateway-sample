package com.vn2bs.common.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthCheckRest {
    @RequestMapping("")
    public String healthCheck() {
        return "OK";
    }
}
