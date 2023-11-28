package com.lito.taller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/litoTallet")
public class health {

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}
