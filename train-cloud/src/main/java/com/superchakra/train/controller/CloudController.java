package com.superchakra.train.controller;


import com.superchakra.train.client.CircuitBreakerClient;
import com.superchakra.train.client.GatewayClient;
import com.superchakra.train.client.OpenfeignClient;
import com.superchakra.train.reponse.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudController implements CloudControllerApi {

    @Resource
    private OpenfeignClient openfeignClient;

    @Resource
    private CircuitBreakerClient circuitBreakerClient;

    @Resource
    private GatewayClient gatewayClient;


    @Override
    public Result openFeignHello() {
        return openfeignClient.getHello();
    }

    @Override
    public Result openFeignCode(String id) {
        return openfeignClient.getCode(id);
    }

    @Override
    public Result circuitHello() {
        return circuitBreakerClient.getHello();
    }

    @Override
    public Result circuitCode(String id) {
        return circuitBreakerClient.getCode(id);
    }

    @Override
    public Result gatewayHello() {
        return gatewayClient.getHello();
    }

    @Override
    public Result gatewayCode(String id) {
        return gatewayClient.getCode(id);
    }
}
