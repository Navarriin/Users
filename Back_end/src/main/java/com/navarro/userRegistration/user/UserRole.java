package com.navarro.userRegistration.user;

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
