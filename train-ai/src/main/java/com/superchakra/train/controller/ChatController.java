package com.superchakra.train.controller;

import com.superchakra.train.reponse.Result;
import com.superchakra.train.reponse.ResultStatusEnum;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


import java.util.stream.Collectors;

@RestController
public class ChatController implements ChatControllerApi {

    //引入ChatClient接口
    private final ChatClient chatClient;

    //将原型 ChatClient.Builder Bean 供您注入类中
    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * TODO：以 String 形式返回 AI 模型的响应。
     * 你看到返回Result,是因为我的所有的返回结果，进行了统一封装
     *
     * @param msg
     * @return
     */
    @Override
    public Result<String> Chat1(String msg) {
        String content = chatClient.prompt()
                .user(msg)
                .call()
                .content();

        return new Result<String>().success(ResultStatusEnum.SUCCESS, content);
    }

    /**
     * TODO；返回包含元数据的 ChatResponse 对象
     * 你看到返回Result,是因为我的所有的返回结果，进行了统一封装
     *
     * @param msg
     * @return
     */
    @Override
    public Result<ChatResponse> Chat2(String msg) {

        ChatResponse chatResponse = chatClient.prompt()
                .user(msg)
                .call()
                .chatResponse();

        return new Result<ChatResponse>().success(ResultStatusEnum.SUCCESS, chatResponse);
    }

    /**
     * TODO:以 String 形式返回 AI 模型的响应。
     *
     * @param msg
     * @return
     */

    @Override
    public Result<String> Chat3(String msg) {

        Flux<String> flux = chatClient.prompt()
                .user(msg)
                .stream()
                .content();

        String content = flux.collectList().block().stream().collect(Collectors.joining());

        return new Result<String>().success(ResultStatusEnum.SUCCESS, content);
    }

    /**
     * TODO:返回包含元数据的 ChatResponse对象（未实现）
     *
     * @param msg
     * @return
     */

    @Override
    public Result<ChatResponse> Chat4(String msg) {

        /**
         * TODO:实现流式调用API,来实现返回Flux<ChatResponse>,然后转为ChatResponse对象，返回数据。
         */

        return new Result<ChatResponse>().success(ResultStatusEnum.SUCCESS, null);
    }

    /**
     * TODO:矢量检索增强（未实现）
     *
     * @param msg
     * @return
     */

    @Override
    public Result Chat5(String msg) {


        return null;
    }

    /**
     * TODO:聊天记忆,实现上下文的检索（未实现）
     *
     * @param msg
     * @return
     */
    @Override
    public Result Chat6(String msg) {


        return null;
    }

}
