package com.superchakra.train.client;

import com.superchakra.train.reponse.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "train-gateway")
public interface GatewayClient {

    @GetMapping("/gateway/hello")
    Result getHello();

    @GetMapping("/gateway/code")
    Result getCode(@RequestParam("id") String id);


}
