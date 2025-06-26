package com.example.demo.application.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private double price;
}
