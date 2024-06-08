package com.superchakra.train.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/consul")
@CrossOrigin
@Tag(name="consul模块",description = "consul服务接口")
public interface ConsulControllerApi extends HelloControllerApi {

}
