package com.example.demo.application.third_party.simplize_service.service.impl;

import com.example.demo.application.third_party.BaseThirdPartyService;
import com.example.demo.application.third_party.simplize_service.response.CompanyInfo;
import com.example.demo.application.third_party.simplize_service.response.HistoryQuote;
import com.example.demo.application.third_party.simplize_service.response.SimplizeResponse;
import com.example.demo.application.third_party.simplize_service.service.SimplizeBetterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Slf4j
@Service
public class SimplizeBetterServiceImpl extends BaseThirdPartyService implements SimplizeBetterService {

    public SimplizeBetterServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        super(restTemplate, objectMapper);
    }

    @PostConstruct
    public void init() {
        Optional<HistoryQuote> data1 = getHistoricalQuoteBySymbol("HPG", "stock");
        Optional<CompanyInfo> data2 = searchCompanyInfoBySymbol("CEO");
        log.info("data1={}, data2={}", data1, data2);
    }

    @Override
    public Optional<HistoryQuote> getHistoricalQuoteBySymbol(String symbol, String type) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/api/historical/quote/{symbol}")
                .queryParam("type", type)
                .buildAndExpand(symbol)
                .toUriString();
        return get(url, new ParameterizedTypeReference<SimplizeResponse<HistoryQuote>>() {});
    }

    @Override
    public Optional<CompanyInfo> searchCompanyInfoBySymbol(String symbol) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/api/search/company/info")
                .queryParam("q", symbol)
                .buildAndExpand(symbol)
                .toUriString();
        return get(url, new ParameterizedTypeReference<SimplizeResponse<CompanyInfo>>() {});
    }
}
