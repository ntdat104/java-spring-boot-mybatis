package com.example.demo.application.third_party.simplize_service.service;

import com.example.demo.application.third_party.simplize_service.response.CompanyInfo;
import com.example.demo.application.third_party.simplize_service.response.HistoryQuote;

import java.util.Optional;

public interface SimplizeBetterService {
    Optional<HistoryQuote> getHistoricalQuoteBySymbol(String symbol, String type);
    Optional<CompanyInfo> searchCompanyInfoBySymbol(String symbol);
}
