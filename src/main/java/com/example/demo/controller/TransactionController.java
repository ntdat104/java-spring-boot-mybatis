package com.example.demo.controller;

import com.example.demo.dto.TransactionSearchRequest;
import com.example.demo.dto.TransactionSearchResponse;
import com.example.demo.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionMapper transactionMapper;

    @PostMapping("/search")
    public TransactionSearchResponse searchTransactions(@RequestBody TransactionSearchRequest request) {
        TransactionSearchResponse response = new TransactionSearchResponse();
        response.setTransactions(transactionMapper.searchTransactions(request));
        long total = transactionMapper.countTransactions(request);
        response.setTotal(total);
        return response;
    }
}