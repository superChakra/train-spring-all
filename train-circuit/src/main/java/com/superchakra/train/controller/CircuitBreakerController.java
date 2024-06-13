package com.superchakra.train.controller;


import com.superchakra.train.reponse.Result;
import com.superchakra.train.reponse.ResultStatusEnum;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class CircuitBreakerController implements CircuitBreakerControllerApi{


    @Override
    public Result hello() {

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Result().success(ResultStatusEnum.SUCCESS,"Hello CircuitBreaker!");
    }

    @Override
    public Result code(String id) {

        if ("1".equals(id)) {
            throw new RuntimeException("id不能为:" + id);
        }

        if ("2".equals(id)) {

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String code = UUID.randomUUID().toString().replaceAll("-","");
        return new Result().success(ResultStatusEnum.SUCCESS, "CircuitBreaker:" + code);
    }
}
