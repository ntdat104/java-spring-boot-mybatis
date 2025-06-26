package com.example.demo.domain.repository.impl;

import com.example.demo.application.dto.request.SearchDataRequest;
import com.example.demo.application.dto.request.TransactionSearchRequest;
import com.example.demo.domain.mapper.TransactionDynamicMapper;
import com.example.demo.domain.mapper.TransactionMapper;
import com.example.demo.domain.mapper.TransactionWithDetailMapper;
import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.repository.TransactionRepository;
import com.example.demo.application.utils.TransactionQueryBuilderUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
    private final TransactionMapper transactionMapper;
    private final TransactionWithDetailMapper transactionWithDetailMapper;
    private final TransactionDynamicMapper transactionDynamicMapper;

    @Override
    public List<Transaction> searchTransactions(TransactionSearchRequest request) {
        return transactionMapper.searchTransactions(request);
    }

    @Override
    public long countTransactions(TransactionSearchRequest request) {
        return transactionMapper.countTransactions(request);
    }

    @Override
    public List<Transaction> searchTransactionsWithDetails(TransactionSearchRequest request) {
        return transactionWithDetailMapper.searchTransactionsWithDetails(request);
    }

    @Override
    public long countTransactionsWithDetails(TransactionSearchRequest request) {
        return transactionWithDetailMapper.countTransactionsWithDetails(request);
    }

    @Override
    public List<Transaction> searchTransactionsDynamic(SearchDataRequest request) {
        // Convert request to query parameters
        Map<String, Object> queryParams = TransactionQueryBuilderUtil.buildQueryParams(request);
        return transactionDynamicMapper.searchTransactionsDynamic(queryParams);
    }

    @Override
    public long countTransactionsDynamic(SearchDataRequest request) {
        // Convert request to query parameters
        Map<String, Object> queryParams = TransactionQueryBuilderUtil.buildQueryParams(request);
        return transactionDynamicMapper.countTransactionsDynamic(queryParams);
    }
}
