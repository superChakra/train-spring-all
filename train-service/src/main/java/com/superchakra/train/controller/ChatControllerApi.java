package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/springAi")
@CrossOrigin
@Tag(name = "springAI接口", description = "springAI的接口")
public interface ChatControllerApi {

    @Operation(method = "GET",summary = "文本AI交流")
    @GetMapping("/chat1")
    Result getChat1(@RequestParam("msg") String msg);

    @Operation(method = "GET",summary = "获取图片接口")
    @GetMapping("/chat2")
    Result getChat2(@RequestParam("msg") String msg);


    @Operation(method = "POST",summary = "图片交流")
    @PostMapping("/chat3")
    Result postChat3(@RequestParam("photo") File photo, @RequestParam("msg") String msg);


}
