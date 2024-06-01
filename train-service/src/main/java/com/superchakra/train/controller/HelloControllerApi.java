package com.superchakra.train.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface HelloControllerApi {

    @GetMapping("/hello")
    String hello();
}
