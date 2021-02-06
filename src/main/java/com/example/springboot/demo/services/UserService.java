package com.example.springboot.demo.services;

import antlr.ASTNULLType;
import com.example.springboot.demo.daos.UserRepository;
import com.example.springboot.demo.domains.User;
import com.example.springboot.demo.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto save(UserDto dto) {
        User user = userRepository.save(userMapper.map(dto));
        return userMapper.map(user);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(this.userMapper::map).collect(Collectors.toList());
    }
}
