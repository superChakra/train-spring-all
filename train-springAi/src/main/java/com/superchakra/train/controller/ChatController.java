package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class ChatController implements ChatControllerApi{

    /**
     * 实现简单的文本交流
     * @param msg
     * @return
     */
    @Override
    public Result getChat1(String msg) {
        return null;
    }

    /**
     * 实现简单的获取一张图片
     * @param msg
     * @return
     */
    @Override
    public Result getChat2(String msg) {
        return null;
    }

    /**
     * 实现上传图片，和文字来获取结果
     * @param photo
     * @param msg
     * @return
     */
    @Override
    public Result postChat3(File photo, String msg) {
        return null;
    }
}
