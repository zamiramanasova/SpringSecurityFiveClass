package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.securemodel.User;
import com.example.springsecurityfivecass.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class UserDetailsServiceImplTest {

    @Autowired
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private UserRepository userRepository;
    private User user1;

    @BeforeEach
    public void setup() {
        user1 = new User(1L,"user","password",true,null);
    }

    @Test
    @Order(1)
    @DisplayName("JUnit test for {1} should load User by email")
    void loadUserByUsername() {
        Mockito.when(userRepository.getUserByUsername("user")).thenReturn(user1);
        userDetailsService.loadUserByUsername(user1.getUserName());
        System.out.println(user1.getUserName() + " authenticated is successfully!");
    }
}