package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import com.superchakra.train.reponse.ResultStatusEnum;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class OpenfeignController implements OpenfeignControllerApi{
    /**
     * TODO:模拟服务的超时,重试,
     *  hello->模拟超时,
     *  code->模拟重试 重试次数控制在3次
     *  模拟超时的时候，你可能需要注释掉glabalConfig里的一个bean,因为它代表了你开启了重试。
     *
     */


    @Override
    public Result hello() {
        try {
            System.out.println("start:" + LocalDateTime.now());
            TimeUnit.SECONDS.sleep(4);
            System.out.println("end:" + LocalDateTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Result().success(ResultStatusEnum.SUCCESS,"Hello Openfeign!");
    }

    @Override
    public Result code(String id) {

        //模拟服务延迟4秒,注意我在bootstrap.yml中配置了一个请求的最大时间，如果超过最大时间，就会报错，
        //如果开启了重试机制,它会尝试继续请求,直到最大的重试次数.
        try {
            System.out.println("start:" + LocalDateTime.now());
            TimeUnit.SECONDS.sleep(4);
            System.out.println("end:" + LocalDateTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String code = UUID.randomUUID().toString().replaceAll("-","");
        return new Result().success(ResultStatusEnum.SUCCESS, "Openfeign:" + code);
    }


}
