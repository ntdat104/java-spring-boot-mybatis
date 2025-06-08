package com.example.demo.mapper;

import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.TransactionSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {
    List<TransactionDto> searchTransactions(TransactionSearchRequest request);
    long countTransactions(TransactionSearchRequest request);
}