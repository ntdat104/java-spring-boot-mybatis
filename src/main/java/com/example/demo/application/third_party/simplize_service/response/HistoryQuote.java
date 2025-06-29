package com.example.demo.application.third_party.simplize_service.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HistoryQuote implements Serializable {
    private Long priceClose;
    private Long priceOpen;
    private Long priceLow;
    private Long priceHigh;
    private Long priceFloor;
    private Long priceCeiling;
    private Long priceReference;
    private Double priceAverage;
    private Long totalValue;
    private Long buyQuantity;
    private Long sellQuantity;
    private Long totalVolume;
}
