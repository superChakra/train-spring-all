package com.superchakra.train.exception;

import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
       logger.error(e.getMessage());
        return e.getMessage();
    }



    @ExceptionHandler(JwtException.class)
    public String jwtException(JwtException e) {
       logger.error(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler({NoSuchAlgorithmException.class, InvalidKeySpecException.class})
    public String encryptException(Exception e) {
      logger.error("密码哈希加密错误：{}", e.getMessage());
        return e.getMessage();
    }
    @ExceptionHandler(RuntimeException.class)
    public String runtimeException(Exception e) {
        logger.error("用户超时了:"+ e.getMessage());
        return e.getMessage();
    }
}
