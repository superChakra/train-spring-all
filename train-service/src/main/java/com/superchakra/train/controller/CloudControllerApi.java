package com.superchakra.train.controller;


import com.superchakra.train.reponse.Result;
import com.superchakra.train.reponse.ResultStatusEnum;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloud")
@CrossOrigin
@Tag(name = "cloud模块", description = "cloud模块接口")
public interface CloudControllerApi {

    @Operation(method = "GET",summary = "train-openfeign中hello测试")
    @GetMapping("/openfeign/hello")
    Result openFeignHello();

    @Operation(method = "GET",summary = "train-openfeign中code测试")
    @GetMapping("/openfeign/code")
    Result openFeignCode(@RequestParam("id") String id);


    @CircuitBreaker(name = "train-circuit",fallbackMethod = "GlobalFallbackHandler")
    @Operation(method = "GET",summary = "train-circuit中hello测试")
    @GetMapping("/circuit/hello")
    Result circuitHello();

    @CircuitBreaker(name = "train-circuit",fallbackMethod = "GlobalFallbackHandler")
    @Operation(method = "GET",summary = "train-circuit中code测试")
    @GetMapping("/circuit/code")
    Result circuitCode(@RequestParam("id") String id);



    @Operation(method = "GET",summary = "train-gateway中hello测试")
    @GetMapping("/gateway/hello")
    Result gatewayHello();

    @Operation(method = "GET",summary = "train-gateway中code测试")
    @GetMapping("/gateway/code")
    Result gatewayCode(@RequestParam("id") String id);


    // TODO: 回退方法
    default Result GlobalFallbackHandler(String id, Throwable throwable) {
        // 提供回退响应
        return new Result().error(ResultStatusEnum.FAILED, "ID:" + id + "   ERROR: 系统繁忙,请稍后再试!");
    }
}
