package com.superchakra.train.exception;

import com.superchakra.train.reponse.Result;
import com.superchakra.train.reponse.ResultStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestControllerAdvice
public class SecurityException {
/*

    private final Logger logger = LoggerFactory.getLogger(SecurityException.class);


    */
/**
     * TODO:这里是处理Security密码检查器，检查后报出401异常不合理性，这里我是安装前后端分离的项目进行了处理，
     *  如果你是前后端不分的情况，你可以重定向到密码修改页面。
     * @param ex
     * @param attributes
     * @return
     *//*

    @ExceptionHandler(CompromisedPasswordException.class)
    public Result handleCompromisedPasswordException(CompromisedPasswordException ex, RedirectAttributes attributes) {
        attributes.addFlashAttribute("error", ex.getMessage());
        return new Result<String>().error(ResultStatusEnum.FAILED, ex.getMessage());
    }
*/



}
