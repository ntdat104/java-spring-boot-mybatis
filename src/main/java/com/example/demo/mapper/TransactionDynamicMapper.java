package com.example.demo.mapper;

import com.example.demo.dto.TransactionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TransactionDynamicMapper {
    List<TransactionDto> searchTransactionsDynamic(Map<String, Object> queryParams);
    long countTransactionsDynamic(Map<String, Object> queryParams);
}
