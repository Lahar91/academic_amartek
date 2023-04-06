package com.academic.amartek.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api")
public class RestArrangeInterview {

    @GetMapping("interview")
    public ResponseEntity<Object> Get() {
        
    }
}
