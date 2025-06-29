package com.example.demo.application.third_party.simplize_service.service.impl;

import com.example.demo.application.third_party.simplize_service.response.CompanyInfo;
import com.example.demo.application.third_party.simplize_service.response.HistoryQuote;
import com.example.demo.application.third_party.simplize_service.response.SimplizeResponse;
import com.example.demo.application.third_party.simplize_service.service.SimplizeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.UUID;

@Slf4j
@Service
public class SimplizeServiceImpl implements SimplizeService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private String apiKey;
    private String apiSecret;

    @Value("${simplize.base-url:https://api2.simplize.vn}")
    private String baseUrl;

    public SimplizeServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        apiKey = "SERVICE_API_KEY";
        apiSecret = "SERVICE_API_SECRET";
    }

    @Override
    public HistoryQuote getHistoricalQuoteBySymbol(String symbol, String type) {
        String targetUrl = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/api/historical/quote/{symbol}")
                .queryParam("type", type)
                .buildAndExpand(symbol)
                .toUriString();
        HttpEntity<Void> httpEntity = new HttpEntity<>(null, buildHeaders());

        try {
            ResponseEntity<SimplizeResponse<HistoryQuote>> response = restTemplate.exchange(
                    targetUrl,
                    HttpMethod.GET,
                    httpEntity,
                    new ParameterizedTypeReference<SimplizeResponse<HistoryQuote>>() {},
                    symbol
            );
            return response.getBody().getData();

        } catch (HttpStatusCodeException ex) {
            String errorMessage = ex.getResponseBodyAsString();
            log.info("getHistoricalQuoteBySymbol has error: {}", errorMessage);

            try {
                HashMap errorResponse = objectMapper.readValue(errorMessage, HashMap.class);
                int status = (int) errorResponse.get("status");
                log.info("getHistoricalQuoteBySymbol.errorResponse: {}", errorMessage);
                if (HttpStatus.NOT_FOUND.value() == status) {
                    throw new RuntimeException("getHistoricalQuoteBySymbol: 404 Not Found");
                }
            } catch (JsonProcessingException ex2){
                log.error("ERROR PARSE JSON WHEN VALIDATE LIMIT SERVICE: ", ex2);
            }
            return null;
        }
    }

    @Override
    public CompanyInfo searchCompanyInfoBySymbol(String symbol) {
        String targetUrl = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/api/search/company/info")
                .queryParam("q", symbol)
                .buildAndExpand(symbol)
                .toUriString();
        HttpEntity<Void> httpEntity = new HttpEntity<>(null, buildHeaders());

        try {
            ResponseEntity<SimplizeResponse<CompanyInfo>> response = restTemplate.exchange(
                    targetUrl,
                    HttpMethod.GET,
                    httpEntity,
                    new ParameterizedTypeReference<SimplizeResponse<CompanyInfo>>() {},
                    symbol
            );
            return response.getBody().getData();

        } catch (HttpStatusCodeException ex) {
            String errorMessage = ex.getResponseBodyAsString();
            log.info("searchCompanyInfoBySymbol has error: {}", errorMessage);

            try {
                HashMap errorResponse = objectMapper.readValue(errorMessage, HashMap.class);
                int status = (int) errorResponse.get("status");
                log.info("searchCompanyInfoBySymbol.errorResponse: {}", errorMessage);
                if (HttpStatus.NOT_FOUND.value() == status) {
                    throw new RuntimeException("searchCompanyInfoBySymbol: 404 Not Found");
                }
            } catch (JsonProcessingException ex2){
                log.error("ERROR PARSE JSON WHEN VALIDATE LIMIT SERVICE: ", ex2);
            }
            return null;
        }
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Request-ID", UUID.randomUUID().toString());
        headers.set("X_API_KEY", apiKey);
        headers.set("X_API_SECRET", apiSecret);
        return headers;
    }
}
