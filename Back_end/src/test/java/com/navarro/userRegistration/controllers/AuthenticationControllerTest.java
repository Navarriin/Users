package com.navarro.userRegistration.controllers;

import com.navarro.userRegistration.dtos.user.AuthorizationDTO;
import com.navarro.userRegistration.dtos.user.RegisterDTO;
import com.navarro.userRegistration.infra.security.TokenService;
import com.navarro.userRegistration.models.user.enuns.UserRole;
import com.navarro.userRegistration.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
class AuthenticationControllerTest {

    @Mock
    private TokenService tokenService;

    @Mock
    private UserRepository repository;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationController controller;

    private RegisterDTO registerDTO;
    private AuthorizationDTO authorizationDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.registerDTO = new RegisterDTO("login teste", "passarinho12", UserRole.USER);
        this.authorizationDTO = new AuthorizationDTO("login teste", "passarinho12");
    }

    @Test
    void loginSuccess() {
    }

    @Test
    void loginError() {
    }

    @Test
    void registerSuccess() {
    }

    @Test
    void registerError() {
    }

}