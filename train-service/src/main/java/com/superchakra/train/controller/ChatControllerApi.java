package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@CrossOrigin //允许跨域
@Tag(name = "springAI接口", description = "springAI的接口")
public interface ChatControllerApi {

    @Operation(method = "GET",summary = "ChatClientAPI,非流式API,返回String类型的响应")
    @GetMapping("/chat1")
    Result Chat1(@RequestParam("msg") String msg);


    @Operation(method = "GET",summary = "ChatClientAPI,非流式API,返回ChatResponse类型的响应")
    @GetMapping("/chat2")
    Result Chat2(@RequestParam("msg") String msg);


    @Operation(method = "GET",summary = "ChatClientAPI,流式API,返回String类型的响应")
    @GetMapping("/chat3")
    Result Chat3(@RequestParam("msg") String msg);

    @Operation(method = "GET",summary = "ChatClientAPI,流式API,返回ChatResponse类型的响应")
    @GetMapping("/chat4")
    Result Chat4(@RequestParam("msg") String msg);

    @Operation(method = "GET",summary = "ChatClientAPI,矢量检索增强")
    @GetMapping("/chat5")
    Result Chat5(@RequestParam("msg") String msg);


    @Operation(method = "GET",summary = "ChatClientAPI,聊天记忆")
    @GetMapping("/chat6")
    Result Chat6(@RequestParam("msg") String msg);

}
