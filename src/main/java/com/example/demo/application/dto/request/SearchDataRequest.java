package com.example.demo.application.dto.request;

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
