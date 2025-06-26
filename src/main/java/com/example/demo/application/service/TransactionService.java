package com.example.demo.application.service;

import com.example.demo.application.dto.request.SearchDataRequest;
import com.example.demo.application.dto.request.TransactionSearchRequest;
import com.example.demo.application.dto.response.TransactionSearchResponse;

public interface TransactionService {
    TransactionSearchResponse searchTransactions(TransactionSearchRequest request);
    TransactionSearchResponse searchTransactionsWithDetail(TransactionSearchRequest request);
    TransactionSearchResponse searchTransactionsDynamic(SearchDataRequest request);
}
