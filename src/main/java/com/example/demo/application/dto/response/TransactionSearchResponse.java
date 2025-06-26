package com.example.demo.application.dto.response;

import com.example.demo.domain.model.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class TransactionSearchResponse extends BaseResponse {

    private List<Transaction> transactions;
    private Long total;

}