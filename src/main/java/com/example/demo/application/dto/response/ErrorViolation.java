package com.example.demo.application.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ErrorViolation {

    private String field;

    private String code;

    private String description;

    private String message;

    private Object expected;

    private Object actual;

    @JsonIgnore
    public String getErrorMessage() {
        if(!ObjectUtils.isEmpty(description)) {
            return description;
        }
        return message;
    }

}
