package com.example.demo.application.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Meta {

    private Integer code;

    private Long pageIndex;

    private Long pageSize;

    private Long totalItems;

    private List<ErrorViolation> errors;

    private String message;

    private String requestId;

    private String httpCode;

    private String errorCode;

    private String serviceCode;

    @JsonIgnore
    private Integer originalCode;

    @JsonIgnore
    private String originalMessage;

    public Meta(String requestId, int code, Long pageIndex, Long pageSize, long totalItems) {
        this.requestId = requestId;
        this.code = code;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalItems = totalItems;
    }

    public Meta(String requestId, int code, String message) {
        this.requestId = requestId;
        this.code = code;
        this.message = message;
    }

    @SneakyThrows
    @JsonIgnore
    public String getErrorMessage() {
        if(!ObjectUtils.isEmpty(message)) {
            return message;
        }
        if(!ObjectUtils.isEmpty(errors)) {
            return errors.stream().map(ErrorViolation::getMessage)
                    .collect(Collectors.toList())
                    .get(0);
        }
        return this.errorCode;
    }

    @SneakyThrows
    @JsonIgnore
    public String getErrorOriginalMessage() {
        if(!ObjectUtils.isEmpty(errors)) {
            return errors.stream().map(ErrorViolation::getErrorMessage)
                    .collect(Collectors.toList())
                    .get(0);
        }
        if(!ObjectUtils.isEmpty(originalMessage)) {
            return originalMessage;
        }
        return getErrorMessage();
    }

    @SneakyThrows
    @JsonIgnore
    public Integer getErrorOriginalCode() {
        if(!ObjectUtils.isEmpty(originalCode)) {
            return originalCode;
        }
        return this.code;
    }

}
