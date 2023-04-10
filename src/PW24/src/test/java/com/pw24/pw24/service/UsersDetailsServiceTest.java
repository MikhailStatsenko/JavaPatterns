package com.pw24.pw24.service;

import com.pw24.pw24.model.User;
import com.pw24.pw24.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsersDetailsServiceTest {
    private UsersDetailsService usersDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        usersDetailsService = new UsersDetailsService(userRepository);
    }

    @Test
    public void testLoadUserByUsernameWhenUserNotFound() {
        String username = "non existing user";
        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> usersDetailsService.loadUserByUsername(username));
    }

    @Test
    public void testLoadUserByUsername() {
        String username = "user";
        String encodedPassword = "encoded password";
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
        UserDetails userDetails = usersDetailsService.loadUserByUsername(username);
        Assertions.assertEquals(username, userDetails.getUsername());
        Assertions.assertEquals(encodedPassword, userDetails.getPassword());
    }
}
