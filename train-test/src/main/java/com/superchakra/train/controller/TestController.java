package com.superchakra.train.controller;

import java.time.ZonedDateTime;
import java.util.UUID;

public class TestController{

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }

}
