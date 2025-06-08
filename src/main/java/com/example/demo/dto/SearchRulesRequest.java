package com.example.demo.dto;

import lombok.Data;

@Data
public class SearchRulesRequest {
    private String field;
    private Object value;
    private String operator;
}
