package com.pw24.pw24.service;

import com.pw24.pw24.model.User;
import com.pw24.pw24.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTest {
    private RegistrationService registrationService;
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        registrationService = new RegistrationService(userRepository, passwordEncoder);
    }

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        String encodedPassword = "encoded password";
        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn(encodedPassword);

        registrationService.register(user);

        Mockito.verify(userRepository).save(user);
        assertEquals(encodedPassword, user.getPassword());
    }
}