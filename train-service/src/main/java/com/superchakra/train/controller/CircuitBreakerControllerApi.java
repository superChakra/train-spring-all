package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/circuit")
@CrossOrigin
public interface CircuitBreakerControllerApi {

    @GetMapping("/hello")
    Result hello();

    @GetMapping("/code")
    Result code(@RequestParam("id") String id);


}
