package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestControllerApi{


    @Resource
    private OpenfeignControllerApi openfeignControllerApi;

    @Override
    public Result hello() {
        return openfeignControllerApi.hello();
    }

}
