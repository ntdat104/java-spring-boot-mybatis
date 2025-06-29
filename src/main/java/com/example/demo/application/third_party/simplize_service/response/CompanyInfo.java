package com.example.demo.application.third_party.simplize_service.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyInfo implements Serializable {
    private Long companyId;
    private String ticker;
    private String name;
    private String imageUrl;
    private String stockExchange;
    private String type;
    private String[] chartType; // or List<String> chartType;
}
