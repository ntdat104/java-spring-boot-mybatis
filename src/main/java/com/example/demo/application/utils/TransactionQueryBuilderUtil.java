package com.example.demo.application.utils;

import com.example.demo.application.dto.request.SearchDataRequest;
import com.example.demo.application.dto.request.SearchRulesRequest;
import com.example.demo.application.enums.SearchOperationEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionQueryBuilderUtil {
    public static Map<String, Object> buildQueryParams(SearchDataRequest request) {
        Map<String, Object> params = new HashMap<>();

        // Process rules
        List<SearchRulesRequest> processedRules = request.getRules().stream()
                .map(TransactionQueryBuilderUtil::validateRule)
                .toList();

        // Add processed parameters
        params.put("rules", processedRules);
        params.put("sortField", validateSortField(request.getSortField()));
        params.put("sortDirection", validateSortDirection(request.getSortDirection()));
        params.put("page", request.getPage() != null ? request.getPage() : 0);
        params.put("size", request.getSize() != null ? request.getSize() : 10);
        return params;
    }

    private static SearchRulesRequest validateRule(SearchRulesRequest rule) {
        // Validate field against whitelist
        if (!isValidField(rule.getField())) {
            throw new IllegalArgumentException("Invalid field name: " + rule.getField());
        }

        // Validate operator
        var searchOperator = SearchOperationEnum.getByOperator(rule.getOperator());
        if (searchOperator == null) {
            throw new IllegalArgumentException("Invalid search operator: " + rule.getOperator());
        }
        return rule;
    }

    private static boolean isValidField(String field) {
        // Define whitelist of allowed fields
        List<String> allowedFields = List.of(
                "id", "user_id", "amount", "currency", "status", "type",
                "created_at", "updated_at"
        );
        return allowedFields.contains(field);
    }

    private static String validateSortField(String sortField) {
        List<String> allowedSortFields = List.of(
                "id", "user_id", "amount", "created_at",
                "updated_at"
        );
        return allowedSortFields.contains(sortField) ? sortField : "created_at";
    }

    private static String validateSortDirection(String sortDirection) {
        return "ASC".equalsIgnoreCase(sortDirection) ? "ASC" : "DESC";
    }
}
