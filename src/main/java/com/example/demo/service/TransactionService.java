package com.example.demo.service;

import com.example.demo.dto.SearchDataRequest;
import com.example.demo.dto.TransactionSearchRequest;
import com.example.demo.dto.TransactionSearchResponse;

public interface TransactionService {
    TransactionSearchResponse searchTransactions(TransactionSearchRequest request);
    TransactionSearchResponse searchTransactionsWithDetail(TransactionSearchRequest request);
    TransactionSearchResponse searchTransactionsDynamic(SearchDataRequest request);
}
