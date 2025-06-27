package com.example.demo.application.record;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cursor {

    private String id;

    private LocalDateTime createdAt;

}