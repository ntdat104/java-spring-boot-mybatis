package com.example.demo.domain.mapper;

import com.example.demo.domain.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUsersPage(@Param("createdAt") LocalDateTime createdAt,
                               @Param("id") String id,
                               @Param("limit") int limit);
}