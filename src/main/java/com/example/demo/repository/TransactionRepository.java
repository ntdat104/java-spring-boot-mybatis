package com.example.demo.repository;

import com.example.demo.dto.SearchDataRequest;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionSearchRequest;

import java.util.List;

public interface TransactionRepository {
    List<TransactionDto> searchTransactions(TransactionSearchRequest request);
    long countTransactions(TransactionSearchRequest request);

    List<TransactionDto> searchTransactionsWithDetails(TransactionSearchRequest request);
    long countTransactionsWithDetails(TransactionSearchRequest request);

    List<TransactionDto> searchTransactionsDynamic(SearchDataRequest request);
    long countTransactionsDynamic(SearchDataRequest request);
}
