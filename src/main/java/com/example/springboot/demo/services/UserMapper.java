package com.example.springboot.demo.services;

import com.example.springboot.demo.domains.User;
import com.example.springboot.demo.dtos.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserMapper {
    public UserDto map(User user) {
        UserDto dto = new UserDto();
        dto.setCreatedDate(user.getCreatedDate());
        dto.setEmail(user.getEmail());
        dto.setId(user.getId());
        dto.setModifiedDate(user.getModifiedDate());
        dto.setUsername(user.getUsername());
        return dto;
    }

    public User map(UserDto user) {
        User entity = new User();
        entity.setCreatedDate(user.getCreatedDate());
        entity.setEmail(user.getEmail());
        entity.setId(user.getId());
        entity.setModifiedDate(user.getModifiedDate());
        entity.setUsername(user.getUsername());
        return entity;
    }
}
