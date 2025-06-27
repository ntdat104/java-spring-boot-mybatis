package com.example.demo.interfaces.http;

import com.example.demo.application.record.Cursor;
import com.example.demo.application.utils.CursorUtil;
import com.example.demo.domain.mapper.UserMapper;
import com.example.demo.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final CursorUtil cursorUtil;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "10") int limit) throws Exception {

        Cursor decodedCursor = cursorUtil.decode(cursor);

        List<User> users = userMapper.selectUsersPage(
                decodedCursor.getCreatedAt(),
                decodedCursor.getId(),
                limit
        );

        String nextCursor = null;

        if (!users.isEmpty()) {
            Cursor newCursor = new Cursor();
            newCursor.setId(users.get(users.size() - 1).getId());
            newCursor.setCreatedAt(users.get(users.size() - 1).getCreatedAt());
            nextCursor = cursorUtil.encode(newCursor);
        }

        return ResponseEntity.ok(Map.of(
                "users", users,
                "nextCursor", nextCursor
        ));
    }
}