package com.example.demo.domain.mapper;

import com.example.demo.domain.model.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TransactionDynamicMapper {
    List<Transaction> searchTransactionsDynamic(Map<String, Object> queryParams);
    long countTransactionsDynamic(Map<String, Object> queryParams);
}
