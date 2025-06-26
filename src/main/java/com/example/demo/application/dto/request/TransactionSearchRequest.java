package com.example.demo.application.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class TransactionSearchRequest {
    private Set<String> ids;
    private Set<String> userIds;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Set<String> currencies;
    private Set<String> statuses;
    private Set<String> types;

    // Detail filters
    private Set<String> categories;
    private String location;
    private String referenceNumber;
    private String description;

    // Pagination and sorting
    private Integer page = 0;
    private Integer size = 10;
    private String sortBy = "created_at"; // default sort field
    private String sortOrder = "DESC"; // default sort order

    // Helper method to get safe sort column
    public String getSafeSortBy() {
        // Whitelist of allowed sort columns
        Set<String> allowedColumns = Set.of(
                "id", "user_id", "amount", "currency", "status", "type",
                "created_at", "updated_at", "category", "location"
        );
        return allowedColumns.contains(sortBy) ? sortBy : "created_at";
    }

    // Helper method to get safe sort order
    public String getSafeSortOrder() {
        return "ASC".equalsIgnoreCase(sortOrder) ? "ASC" : "DESC";
    }
}