package com.lito.taller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/litoTallet")
public class health {

    @GetMapping("/health")
    public Optional<ResponseBody>
}
