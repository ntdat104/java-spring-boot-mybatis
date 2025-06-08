package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum SearchOperationEnum {
    Equals("Bằng", "="),
    NotEquals("Không bằng", "!="),
    GreaterThan("Lớn hơn", ">"),
    GreaterThanEqual("Lớn hơn hoặc bằng", ">="),
    LessThan("Nhỏ hơn", "<"),
    LessThanEqual("Nhỏ hơn hoặc bằng", "<="),
    IsNull("Is Null", "is_null"),
    NotNull("Not Null", "not_null"),
    In("In", "in"),
    NotIn("Not In", "not_in"),
    Empty("Empty", "empty"),
    NotEmpty("Not Empty", "not_empty"),
    EqualOrNull("Bằng hoặc null", "eq_or_null"),
    Contains("Contains", "like");

    private final String name;
    private final String op;

    private SearchOperationEnum(String name, String op) {
        this.name = name;
        this.op = op;
    }

    public static SearchOperationEnum getByOperator(String op) {
        for (SearchOperationEnum operation : values()) {
            if (operation.getOp().equalsIgnoreCase(op)) {
                return operation;
            }
        }
        return null; // or throw an exception if preferred
    }
}
