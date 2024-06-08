package com.superchakra.train.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenfeignController {

    /**
     * TODO:这里没有实现OpenfeignControllerApi接口
     *  测试代码在train-test中TestController类里
     *  注意如果你要使用负载均衡的时候，封装接口的时候,里面的方法路径需要和你实际调用的接口写的路径要一样
     *  例： OpenfeignControllerApi接口中
     *  hello()方法的请求路径是 /consul/hello,这个路径和train-consul里的hello()方法的请求路径是一样的。
     *
     *
     */

}
