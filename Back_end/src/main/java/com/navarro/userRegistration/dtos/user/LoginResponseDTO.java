package com.navarro.userRegistration.dtos.user;

public record LoginResponseDTO(String token) {

    public String getToken() {
        return token;
    }
}
