package com.example.demo.service;

import com.example.demo.dto.SearchDataRequest;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionSearchRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TransactionAsyncService {
    CompletableFuture<List<TransactionDto>> searchAsyncTransactions(TransactionSearchRequest request);
    CompletableFuture<Long> countAsyncTransactions(TransactionSearchRequest request);

    CompletableFuture<List<TransactionDto>> searchAsyncTransactionsWithDetail(TransactionSearchRequest request);
    CompletableFuture<Long> countAsyncTransactionsWithDetail(TransactionSearchRequest request);

    CompletableFuture<List<TransactionDto>> searchAsyncTransactionsDynamic(SearchDataRequest request);
    CompletableFuture<Long> countAsyncTransactionsDynamic(SearchDataRequest request);
}
