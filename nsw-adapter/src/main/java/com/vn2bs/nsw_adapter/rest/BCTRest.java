package com.vn2bs.nsw_adapter.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/bct")
public class BCTRest {
    @PostMapping("message")
    public ResponseEntity<?> handleMessage(@RequestBody String entity) {
        return ResponseEntity.ok().body(null);
    }

}
