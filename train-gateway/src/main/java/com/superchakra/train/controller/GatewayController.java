package com.superchakra.train.controller;

import com.superchakra.train.client.GatewayClient;
import com.superchakra.train.reponse.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController implements GatewayControllerApi{

    @Resource
    private GatewayClient gatewayClient;

    @Override
    public Result hello() {
        return null;
    }

    @Override
    public Result code(String id) {
        return null;
    }
}
