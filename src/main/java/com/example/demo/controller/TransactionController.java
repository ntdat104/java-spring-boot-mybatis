package com.example.demo.controller;

import com.example.demo.dto.SearchDataRequest;
import com.example.demo.dto.TransactionSearchRequest;
import com.example.demo.service.TransactionService;
import com.example.demo.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/search")
    public ResponseUtil<?> searchTransactions(@RequestBody TransactionSearchRequest request) {
        return ResponseUtil.data(transactionService.searchTransactions(request));
    }

    @PostMapping("/detail/search")
    public ResponseUtil<?> searchTransactionsWithDetail(@RequestBody TransactionSearchRequest request) {
        return ResponseUtil.data(transactionService.searchTransactionsWithDetail(request));
    }

    @PostMapping("/dynamic/search")
    public ResponseUtil<?> searchTransactionsDynamic(@RequestBody SearchDataRequest request) {
        return ResponseUtil.data(transactionService.searchTransactionsDynamic(request));
    }
}