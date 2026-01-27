package com.vn2bs.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vn2bs.common.dto.ResponseFactory;

@Configuration
public class ResponseConfiguration {
    @Bean
    public ResponseFactory responseFactory() {
        return new ResponseFactory();
    }
}
