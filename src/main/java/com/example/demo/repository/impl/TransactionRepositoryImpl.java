package com.example.demo.repository.impl;

import com.example.demo.dto.SearchDataRequest;
import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionSearchRequest;
import com.example.demo.mapper.TransactionDynamicMapper;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.mapper.TransactionWithDetailMapper;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.util.TransactionQueryBuilder;
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
    public List<TransactionDto> searchTransactions(TransactionSearchRequest request) {
        return transactionMapper.searchTransactions(request);
    }

    @Override
    public long countTransactions(TransactionSearchRequest request) {
        return transactionMapper.countTransactions(request);
    }

    @Override
    public List<TransactionDto> searchTransactionsWithDetails(TransactionSearchRequest request) {
        return transactionWithDetailMapper.searchTransactionsWithDetails(request);
    }

    @Override
    public long countTransactionsWithDetails(TransactionSearchRequest request) {
        return transactionWithDetailMapper.countTransactionsWithDetails(request);
    }

    @Override
    public List<TransactionDto> searchTransactionsDynamic(SearchDataRequest request) {
        // Convert request to query parameters
        Map<String, Object> queryParams = TransactionQueryBuilder.buildQueryParams(request);
        return transactionDynamicMapper.searchTransactionsDynamic(queryParams);
    }

    @Override
    public long countTransactionsDynamic(SearchDataRequest request) {
        // Convert request to query parameters
        Map<String, Object> queryParams = TransactionQueryBuilder.buildQueryParams(request);
        return transactionDynamicMapper.countTransactionsDynamic(queryParams);
    }
}
