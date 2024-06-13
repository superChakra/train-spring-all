package com.superchakra.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.superchakra.train")
public class TestMain8889 {
    public static void main(String[] args) {
        SpringApplication.run(TestMain8889.class, args);
    }
}