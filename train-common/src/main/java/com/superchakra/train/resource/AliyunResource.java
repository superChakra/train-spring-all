package com.superchakra.train.resource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("aliyun")
public class AliyunResource {
    private String accessKeyId;
    private String accessKeySecret;

}
