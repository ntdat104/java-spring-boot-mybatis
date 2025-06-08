package com.example.demo.entity;

import lombok.Data;

@Data
public class TransactionDetail {
    private String id;
    private String transactionId;
    private String description;
    private String category;
    private String location;
    private String referenceNumber;
}
