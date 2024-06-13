package com.superchakra.train.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

   /* *//**
     * 注册springSecurity服务，加入spring管理。
     * @param http
     * @return
     * @throws Exception
     *//*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .permitAll()
            )
            .rememberMe(Customizer.withDefaults());

        return http.build();
    }

    *//**
     * TODO：添加密码检查器，如果密码过于简单会返回401异常，但这不是最好的解决方案。
     * @return
     *//*
    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }*/
}