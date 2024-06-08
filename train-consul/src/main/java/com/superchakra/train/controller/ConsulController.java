package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import com.superchakra.train.reponse.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
public class ConsulController implements ConsulControllerApi {

    @Value("${chakra.testStr}")
    private String testStr;

    @Override
    public Result hello() {
        Result result = null;
        try {
            Thread.sleep(3500);
            System.out.println("start: " + LocalDateTime.now());
            result = new Result().success(ResultStatusEnum.SUCCESS, testStr);
            System.out.println("end: " + LocalDateTime.now());
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        return result;
    }
}
