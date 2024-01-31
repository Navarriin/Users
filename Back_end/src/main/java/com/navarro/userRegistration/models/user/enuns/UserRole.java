package com.navarro.userRegistration.models.user.enuns;

public enum UserRole {

    ADMIN("admin"), USER("User");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
