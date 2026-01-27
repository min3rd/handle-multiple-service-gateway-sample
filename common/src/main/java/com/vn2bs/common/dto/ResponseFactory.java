package com.vn2bs.common.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
    public <T> ResponseEntity<IResponse<T>> success(T body) {
        return ResponseEntity.ok(new IResponse<T>() {
            {
                setStatus(HttpStatus.OK);
                setMessage("Success");
                setData(body);
            }
        });
    }

    public ResponseEntity<IResponse<String>> error(HttpStatusCode statusCode, String message) {
        return ResponseEntity.status(statusCode).body(new IResponse<String>() {
            {
                setStatus(statusCode);
                setMessage(message);
                setData(null);
            }
        });
    }
}
