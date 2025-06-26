package com.example.demo.application.dto.request;

import lombok.Data;

@Data
public class SearchRulesRequest {
    private String field;
    private Object value;
    private String operator;
}
