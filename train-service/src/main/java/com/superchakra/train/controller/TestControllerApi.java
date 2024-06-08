package com.superchakra.train.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
@Tag(name = "Train-test模块",description = "一个测试模块接口")
public interface TestControllerApi extends HelloControllerApi{

}
