package com.superchakra.train.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {
    @Bean
    public GroupedOpenApi UserApi()
    {
        return GroupedOpenApi.builder().group("用户模块").pathsToMatch("/user/**").build();
    }
    @Bean
    public GroupedOpenApi AiApi()
    {
        return GroupedOpenApi.builder().group("AI模块").pathsToMatch("/ai/**").build();
    }
    @Bean
    public GroupedOpenApi ConsulApi()
    {
        return GroupedOpenApi.builder().group("cloud模块").pathsToMatch("/cloud/**").build();
    }
    @Bean
    public GroupedOpenApi TestApi()
    {
        return GroupedOpenApi.builder().group("test模块").pathsToMatch("/test/**").build();
    }

    @Bean
    public GroupedOpenApi OtherApi()
    {
        return GroupedOpenApi.builder().group("其它模块").pathsToMatch("/other/**").build();
    }
    @Bean
    public OpenAPI docsOpenApi()
    {
        return new OpenAPI()
                .info(new Info().title("train")
                        .description("后端接口测试文档")
                        .version("v1.0.0"));
    }
}
