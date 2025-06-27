package com.example.demo.application.utils;

import com.example.demo.application.record.Cursor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

@Component
public class CursorUtil {

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public String encode(Cursor cursor) throws JsonProcessingException {
        byte[] json = mapper.writeValueAsBytes(cursor);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(json);
    }

    public Cursor decode(String token) throws IOException {
        if (token == null || token.isBlank()) {
            // Use "max" defaults to get first page
            Cursor cursor = new Cursor();
            cursor.setId("\uFFFF");
            cursor.setCreatedAt(LocalDateTime.MAX);
            return cursor;
        }
        byte[] json = Base64.getUrlDecoder().decode(token);
        return mapper.readValue(json, Cursor.class);
    }
}
