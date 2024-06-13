package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import com.superchakra.train.reponse.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsulController implements ConsulControllerApi {

    @Value("${chakra.info}")
    private String info;


    @Override
    public Result hello() {
        return new Result().success(ResultStatusEnum.SUCCESS, "CONSUL:" + info);
    }

    @Override
    public Result code(String id) {

        return new Result().success(ResultStatusEnum.SUCCESS,
                "CONSUL:" + info + "\nCODE:" + UUID.randomUUID().toString());
    }
}
