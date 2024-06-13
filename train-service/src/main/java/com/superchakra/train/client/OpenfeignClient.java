package com.superchakra.train.client;

import com.superchakra.train.reponse.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "train-openfeign")
public interface OpenfeignClient {

    @GetMapping("/openfeign/hello")
    Result getHello();

    @GetMapping("/openfeign/code")
    Result getCode(@RequestParam("id") String id);

}
