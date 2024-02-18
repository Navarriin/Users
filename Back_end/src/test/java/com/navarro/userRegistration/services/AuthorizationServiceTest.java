package com.navarro.userRegistration.services;

import com.navarro.userRegistration.models.user.User;
import com.navarro.userRegistration.models.user.enuns.UserRole;
import com.navarro.userRegistration.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class AuthorizationServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private AuthorizationService service;

    User userTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.userTest = new User("111u79", "Login test", "senhateste", UserRole.USER);
    }

    @Test
    void loadUserByUsernameSuccess() {
        when(repository.findByLogin(userTest.getLogin())).thenReturn(userTest);

        var result = assertDoesNotThrow(() -> service.loadUserByUsername(userTest.getUsername()));

        assertNotNull(result);
        assertEquals(userTest.getUsername(), result.getUsername());
        verify(repository, times(1)).findByLogin(userTest.getLogin());
    }
}