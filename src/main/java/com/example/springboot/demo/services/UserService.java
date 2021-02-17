package com.example.springboot.demo.services;

import antlr.ASTNULLType;
import com.example.springboot.demo.daos.UserRepository;
import com.example.springboot.demo.domains.User;
import com.example.springboot.demo.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    //    @Autowired
//    private final UserRepository userRepository;
    @Autowired
    private UserRepository userRepository;

    //    @Autowired
//    @Autowired
    private UserMapper userMapper = new UserMapper();
//    private final UserMapper userMapper;


//    @Autowired
//    public UserService(UserRepository userRepository, UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//    }

    public UserDto save(UserDto dto) {
        User user = userRepository.save(userMapper.map(dto));
        return userMapper.map(user);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(this.userMapper::map).collect(Collectors.toList());
    }

    public UserDto getById(Long pId) {
        Optional<User> lById = userRepository.findById(pId);
//        this.userMapper.map(lById.get())
        Optional<UserDto> userDto = lById.map(this.userMapper::map);
        UserDto userDto1 = userDto.orElse(null);
        return userDto1;
    }

    public String get() {
        return "Hello JUnit 5";
    }
}
