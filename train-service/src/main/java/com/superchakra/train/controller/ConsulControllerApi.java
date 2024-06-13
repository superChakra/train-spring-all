package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/consul")
@CrossOrigin
@Tag(name = "train-consul",description = "train-consul模块接口")
public interface ConsulControllerApi {

    @Operation(method = "GET",summary = "train-consul模块总hello测试")
    @GetMapping("/hello")
    Result hello();

    @Operation(method = "GET",summary = "train-consul模块总code测试")
    @GetMapping("/code")
    Result code(@RequestParam("id") String id);

}
