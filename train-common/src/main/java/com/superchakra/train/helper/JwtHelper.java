package com.superchakra.train.helper;

import com.superchakra.train.resource.JwtResource;
import io.jsonwebtoken.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


import java.util.Date;
import java.util.Map;
import java.util.UUID;


@Component
public class JwtHelper {

    @Resource
    private JwtResource jwtResource;

    /**
     * 这个我还没有搞清楚具体的作用
     */
    private String audience;

    /**
     * TODO：用户多个数据的存放
     */

    public String generateToken(Map<String, Object> claims) {

        /**
         * TODO：这个是官网给的生成随机的key用于token签名的
         */
        // SecretKey key = Jwts.SIG.HS512.key().build();
        System.out.println(jwtResource.getSecret());

        SecretKey key = new SecretKeySpec(jwtResource.getSecret().getBytes(), SignatureAlgorithm.HS512.getJcaName());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(jwtResource.getIssuer())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtResource.getExpiration()))
                .setId(UUID.randomUUID().toString())
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    /**
     * TODO：用于单个标识数据的存放
     * 用户的唯一标识符，如果你只想放一个声明数据在token里建议使用这个，
     * 如果你要放多个声明数据，在token里建议使用claims，
     * 如果你要放文件或其他字节数组，建议使用content
     */

    public String generateToken(String subject) {

        SecretKey key = new SecretKeySpec(jwtResource.getSecret().getBytes(), SignatureAlgorithm.HS512.getJcaName());

        return Jwts.builder()
                .setSubject(subject)
                .setIssuer(jwtResource.getIssuer())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtResource.getExpiration()))
                .setId(UUID.randomUUID().toString())
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }


    public Claims parseToken(String token) {
        SecretKey key = new SecretKeySpec(jwtResource.getSecret().getBytes(), SignatureAlgorithm.HS512.getJcaName());

        try {
            return Jwts.parser()
                   .verifyWith(key)
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
        } catch (JwtException e) {
            throw new RuntimeException(e);
        }

    }

    public void generateCookie(HttpServletResponse response , String token, String userId) {
        //设置cookie，并设置cookie的有效日期是1天
        Cookie cookie = new Cookie("token", token);
        cookie.setAttribute("userId",userId);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
    }


}
