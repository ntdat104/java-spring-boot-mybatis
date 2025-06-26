package com.example.demo.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public enum TransactionTypeEnum {

    PAYMENT("PAYMENT","Thanh toán"),
    VOID("VOID", "Hủy"),
    REFUND("REFUND", "Hoàn trả");

    private final String value;
    private final String displayName;

    private static final HashMap<String, TransactionTypeEnum> LOOKUP = new HashMap<>();

    static {
        for (final TransactionTypeEnum item : TransactionTypeEnum.values()) {
            LOOKUP.put(item.name(), item);
        }
    }

    public static TransactionTypeEnum get(String name, TransactionTypeEnum defaultValue) {
        return LOOKUP.getOrDefault(name, defaultValue);
    }

    public static TransactionTypeEnum get(String name) {
        return LOOKUP.get(name);
    }

}
