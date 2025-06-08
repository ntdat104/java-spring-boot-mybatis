package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private String id;
    private String userId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Detail fields
    private String description;
    private String category;
    private String location;
    private String referenceNumber;
}