package com.example.demo.domain.repository;

import com.example.demo.application.dto.request.SearchDataRequest;
import com.example.demo.application.dto.request.TransactionSearchRequest;
import com.example.demo.domain.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> searchTransactions(TransactionSearchRequest request);
    long countTransactions(TransactionSearchRequest request);

    List<Transaction> searchTransactionsWithDetails(TransactionSearchRequest request);
    long countTransactionsWithDetails(TransactionSearchRequest request);

    List<Transaction> searchTransactionsDynamic(SearchDataRequest request);
    long countTransactionsDynamic(SearchDataRequest request);
}
