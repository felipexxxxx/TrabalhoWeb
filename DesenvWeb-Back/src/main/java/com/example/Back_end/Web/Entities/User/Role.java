package com.example.Back_end.Web.Entities.User;

public enum Role {
    CLIENTE("CLIENTE"),
    ADM("ADM");

    private String role;
    Role(String role) {
        this.role = role;
    }
    public String getAuthority() {
        return role;
    }
}
