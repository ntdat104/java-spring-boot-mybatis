package com.example.demo.controller;

import com.example.demo.dto.TransactionSearchRequest;
import com.example.demo.dto.TransactionSearchResponse;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.mapper.TransactionWithDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions/detail")
public class TransactionWithDetailController {
    private final TransactionWithDetailMapper transactionWithDetailMapper;

    @PostMapping("/search")
    public TransactionSearchResponse searchTransactions(@RequestBody TransactionSearchRequest request) {
        TransactionSearchResponse response = new TransactionSearchResponse();
        response.setTransactions(transactionWithDetailMapper.searchTransactionsWithDetails(request));
        long total = transactionWithDetailMapper.countTransactionsWithDetails(request);
        response.setTotal(total);
        return response;
    }
}
