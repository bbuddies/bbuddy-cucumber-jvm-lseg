package com.odde.cucumber.api;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = {"com.odde.cucumber"})
@Configuration
public class Feign implements RequestInterceptor {
    public static String authorization = "";

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", authorization);
    }
}
