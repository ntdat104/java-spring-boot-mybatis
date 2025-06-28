package com.example.demo.application.service.impl;

import com.example.demo.application.dto.request.SearchDataRequest;
import com.example.demo.application.dto.request.TransactionSearchRequest;
import com.example.demo.application.dto.response.TransactionSearchResponse;
import com.example.demo.application.service.TransactionAsyncService;
import com.example.demo.application.service.TransactionService;
import com.example.demo.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionAsyncService transactionAsyncService;

    @Override
    public TransactionSearchResponse searchTransactions(TransactionSearchRequest request) {
        try {
            CompletableFuture<List<Transaction>> transactionsFuture =  transactionAsyncService.searchAsyncTransactions(request);
            CompletableFuture<Long> countFuture = transactionAsyncService.countAsyncTransactions(request);
            CompletableFuture.allOf(transactionsFuture, countFuture).join();

            TransactionSearchResponse response = new TransactionSearchResponse();
            response.setTransactions(transactionsFuture.get());
            response.setTotal(countFuture.get());
            return response;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Async processing failed", e);
        }
    }

    @Override
    public TransactionSearchResponse searchTransactionsWithDetail(TransactionSearchRequest request) {
        try {
            CompletableFuture<List<Transaction>> transactionsFuture =  transactionAsyncService.searchAsyncTransactionsWithDetail(request);
            CompletableFuture<Long> countFuture = transactionAsyncService.countAsyncTransactionsWithDetail(request);
            CompletableFuture.allOf(transactionsFuture, countFuture).join();

            TransactionSearchResponse response = new TransactionSearchResponse();
            response.setTransactions(transactionsFuture.get());
            response.setTotal(countFuture.get());
            return response;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Async processing failed", e);
        }
    }

    @Override
    public TransactionSearchResponse searchTransactionsDynamic(SearchDataRequest request) {
        try {
            CompletableFuture<List<Transaction>> transactionsFuture =  transactionAsyncService.searchAsyncTransactionsDynamic(request);
            CompletableFuture<Long> countFuture = transactionAsyncService.countAsyncTransactionsDynamic(request);
            CompletableFuture.allOf(transactionsFuture, countFuture).join();

            TransactionSearchResponse response = new TransactionSearchResponse();
            response.setTransactions(transactionsFuture.get());
            response.setTotal(countFuture.get());
            return response;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Async processing failed", e);
        }
    }

}
