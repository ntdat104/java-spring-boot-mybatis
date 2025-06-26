package com.example.demo.application.service.impl;

import com.example.demo.application.constant.Constant;
import com.example.demo.application.dto.request.SearchDataRequest;
import com.example.demo.application.dto.request.TransactionSearchRequest;
import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.repository.TransactionRepository;
import com.example.demo.application.service.TransactionAsyncService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class TransactionAsyncServiceImpl implements TransactionAsyncService {
    private TransactionRepository transactionRepository;

    @Override
    @Async(Constant.CUSTOM_EXECUTOR)
    public CompletableFuture<List<Transaction>> searchAsyncTransactions(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.searchTransactions(request));
    }

    @Override
    @Async(Constant.CUSTOM_EXECUTOR)
    public CompletableFuture<Long> countAsyncTransactions(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.countTransactions(request));
    }

    @Override
    @Async(Constant.CUSTOM_EXECUTOR)
    public CompletableFuture<List<Transaction>> searchAsyncTransactionsWithDetail(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.searchTransactionsWithDetails(request));
    }

    @Override
    @Async(Constant.CUSTOM_EXECUTOR)
    public CompletableFuture<Long> countAsyncTransactionsWithDetail(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.countTransactionsWithDetails(request));
    }

    @Override
    public CompletableFuture<List<Transaction>> searchAsyncTransactionsDynamic(SearchDataRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.searchTransactionsDynamic(request));
    }

    @Override
    public CompletableFuture<Long> countAsyncTransactionsDynamic(SearchDataRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.countTransactionsDynamic(request));
    }
}
