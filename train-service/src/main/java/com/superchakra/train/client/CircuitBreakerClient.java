package com.superchakra.train.client;


import com.superchakra.train.reponse.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("train-circuit")
public interface CircuitBreakerClient {
    @GetMapping("/circuit/code")
    Result getCode(@RequestParam("id") String id);

    @GetMapping("/circuit/hello")
    Result getHello();


}
