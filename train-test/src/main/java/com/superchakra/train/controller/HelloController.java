package com.superchakra.train.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloControllerApi{
    @Override
    public String hello() {
        return "hello";
    }
}
