package com.example.demo.domain.mapper;

import com.example.demo.application.dto.request.TransactionSearchRequest;
import com.example.demo.domain.model.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionWithDetailMapper {
    List<Transaction> searchTransactionsWithDetails(TransactionSearchRequest request);
    long countTransactionsWithDetails(TransactionSearchRequest request);
}
