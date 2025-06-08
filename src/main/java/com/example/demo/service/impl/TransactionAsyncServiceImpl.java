package com.example.demo.service.impl;

import com.example.demo.constant.Constant;
import com.example.demo.dto.SearchDataRequest;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionSearchRequest;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionAsyncService;
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
    public CompletableFuture<List<TransactionDto>> searchAsyncTransactions(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.searchTransactions(request));
    }

    @Override
    @Async(Constant.CUSTOM_EXECUTOR)
    public CompletableFuture<Long> countAsyncTransactions(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.countTransactions(request));
    }

    @Override
    @Async(Constant.CUSTOM_EXECUTOR)
    public CompletableFuture<List<TransactionDto>> searchAsyncTransactionsWithDetail(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.searchTransactionsWithDetails(request));
    }

    @Override
    @Async(Constant.CUSTOM_EXECUTOR)
    public CompletableFuture<Long> countAsyncTransactionsWithDetail(TransactionSearchRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.countTransactionsWithDetails(request));
    }

    @Override
    public CompletableFuture<List<TransactionDto>> searchAsyncTransactionsDynamic(SearchDataRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.searchTransactionsDynamic(request));
    }

    @Override
    public CompletableFuture<Long> countAsyncTransactionsDynamic(SearchDataRequest request) {
        return CompletableFuture.completedFuture(transactionRepository.countTransactionsDynamic(request));
    }
}
