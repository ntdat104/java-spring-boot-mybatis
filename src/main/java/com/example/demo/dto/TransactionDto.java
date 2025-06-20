package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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