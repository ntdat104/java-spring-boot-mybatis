package com.example.demo.service.impl;

import com.example.demo.dto.SearchDataRequest;
import com.example.demo.dto.TransactionSearchRequest;
import com.example.demo.dto.TransactionSearchResponse;
import com.example.demo.service.TransactionAsyncService;
import com.example.demo.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionAsyncService transactionAsyncService;

    @Override
    public TransactionSearchResponse searchTransactions(TransactionSearchRequest request) {
        try {
            var transactionsFuture =  transactionAsyncService.searchAsyncTransactions(request);
            var countFuture = transactionAsyncService.countAsyncTransactions(request);
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
            var transactionsFuture =  transactionAsyncService.searchAsyncTransactionsWithDetail(request);
            var countFuture = transactionAsyncService.countAsyncTransactionsWithDetail(request);
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
            var transactionsFuture =  transactionAsyncService.searchAsyncTransactionsDynamic(request);
            var countFuture = transactionAsyncService.countAsyncTransactionsDynamic(request);
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
