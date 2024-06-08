package com.superchakra.train.controller;


import com.superchakra.train.reponse.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@FeignClient(value = "train-consul")
@Tag(name = "Openfeign模块",description = "一个负载均衡模块接口")
public interface OpenfeignControllerApi {

    @GetMapping("/consul/hello")
    @Operation(method = "GET",summary = "通用模块的测试方法")
    Result hello();
}
