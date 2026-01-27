package com.vn2bs.common.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class IResponse<T> {
    private HttpStatusCode status = HttpStatus.OK;
    private String message = "";
    private T data;
}
