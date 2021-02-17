package com.example.springboot.demo;

import com.example.springboot.demo.daos.UserRepository;
import com.example.springboot.demo.domains.User;
import com.example.springboot.demo.dtos.UserDto;
import com.example.springboot.demo.mappers.UserMapper;
import com.example.springboot.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestUserService {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;


    @BeforeEach
    void setMockOutput() {
        User lMockUser = new User();
        lMockUser.setId(1L);
        lMockUser.setUsername("testuser");
        lMockUser.setModifiedDate(Instant.ofEpochSecond(1));
        lMockUser.setCreatedDate(Instant.ofEpochSecond(1));
        lMockUser.setEmail("test@test.com");
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(lMockUser));
    }

    @DisplayName("Test User Service: Get By Id")
    @Test
    void testGetById1() {
        UserDto lExpected = new UserDto();
        lExpected.setId(1L);
        lExpected.setUsername("testuser");
        lExpected.setModifiedDate(Instant.ofEpochSecond(1));
        lExpected.setCreatedDate(Instant.ofEpochSecond(1));
        lExpected.setEmail("test@test.com");

        UserDto lActual = userService.getById(1L);

//        Mockito.verify(userMapper, Mockito.times(2).description("Must be executed 2 times")).map(ArgumentMatchers.any(User.class));

        assertEquals(lExpected, lActual);
    }
}
