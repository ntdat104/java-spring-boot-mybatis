package com.example.demo.infrastructure.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
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
        PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
        poolingConnManager.setMaxTotal(apiCallRequestPoolSize);
        poolingConnManager.setDefaultMaxPerRoute(apiCallRequestPoolSize);
        HttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectionRequestTimeout(apiCallRequestTimeoutMilliseconds)
                        .setSocketTimeout(apiCallRequestTimeoutMilliseconds)
                        .setConnectTimeout(apiCallRequestTimeoutMilliseconds)
                        .build())
                .setConnectionManager(poolingConnManager)
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectionRequestTimeout(apiCallRequestTimeoutMilliseconds);
        requestFactory.setConnectTimeout(apiCallRequestTimeoutMilliseconds);
        requestFactory.setReadTimeout(apiCallRequestTimeoutMilliseconds);
        requestFactory.setHttpClient(client);
        return new RestTemplate(requestFactory);
    }

}
