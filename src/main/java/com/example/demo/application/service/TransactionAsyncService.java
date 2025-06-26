package com.example.demo.application.service;

import com.example.demo.application.dto.request.SearchDataRequest;
import com.example.demo.application.dto.request.TransactionSearchRequest;
import com.example.demo.domain.model.Transaction;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TransactionAsyncService {
    CompletableFuture<List<Transaction>> searchAsyncTransactions(TransactionSearchRequest request);
    CompletableFuture<Long> countAsyncTransactions(TransactionSearchRequest request);

    CompletableFuture<List<Transaction>> searchAsyncTransactionsWithDetail(TransactionSearchRequest request);
    CompletableFuture<Long> countAsyncTransactionsWithDetail(TransactionSearchRequest request);

    CompletableFuture<List<Transaction>> searchAsyncTransactionsDynamic(SearchDataRequest request);
    CompletableFuture<Long> countAsyncTransactionsDynamic(SearchDataRequest request);
}
