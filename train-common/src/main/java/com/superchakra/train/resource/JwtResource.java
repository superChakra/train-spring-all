package com.superchakra.train.resource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
@Data
public class JwtResource {
    private String issuer;
    private long expiration;
    private String secret;

}
