package com.example.demo.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class TransactionSearchResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private List<TransactionDto> transactions;
    private Long total;
}