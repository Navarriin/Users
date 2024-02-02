package com.navarro.userRegistration.dtos.user;

import com.navarro.userRegistration.models.user.enuns.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
    
}
