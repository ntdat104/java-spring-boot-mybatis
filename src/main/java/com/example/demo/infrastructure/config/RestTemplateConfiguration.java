package com.example.demo.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Value("${api.call.request.timeout.milliseconds}")
    private int apiCallRequestTimeoutMilliseconds;

    @Value("${api.call.request.pool-size}")
    private int apiCallRequestPoolSize;

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(apiCallRequestTimeoutMilliseconds);
        factory.setReadTimeout(apiCallRequestTimeoutMilliseconds);
        return new RestTemplate(factory);
    }

}
