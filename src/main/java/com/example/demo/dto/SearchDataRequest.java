package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchDataRequest {
    private Integer page;
    private Integer size;
    private List<SearchRulesRequest> rules;
    private String sortField;
    private String sortDirection;
}
