package com.example.demo.application.third_party.simplize_service.service;

import com.example.demo.application.third_party.simplize_service.response.CompanyInfo;
import com.example.demo.application.third_party.simplize_service.response.HistoryQuote;

public interface SimplizeService {
    HistoryQuote getHistoricalQuoteBySymbol(String symbol, String type);
    CompanyInfo searchCompanyInfoBySymbol(String symbol);
}
