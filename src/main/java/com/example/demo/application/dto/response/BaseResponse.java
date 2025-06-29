package com.example.demo.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseResponse<T> implements Serializable {

    /** Unique identifier associated with the request (useful for tracing). */
    private String requestId;

    /** UTC timestamp of the response. */
    private Long timestamp = System.currentTimeMillis();

    /** Human-readable message (e.g. "Success", "Invalid input", etc.). */
    private String message;

    /** Optional error code for client-side logic. */
    private Integer errorCode;

    /** Actual data payload (generic). */
    private T data;

    public BaseResponse(String requestId, String message, T data) {
        this.requestId = requestId;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String requestId, String message, Integer errorCode) {
        this.requestId = requestId;
        this.message = message;
        this.errorCode = errorCode;
    }
}