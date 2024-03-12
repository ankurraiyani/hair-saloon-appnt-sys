package com.SalonSphereServer.response;

public class LoginResponse {

    private String jwtToken;
    private String name;
    private String role;
    private String userId;

    @Override
    public String toString() {
        return "LoginResponse [jwtToken=" + jwtToken + ", name=" + name + ", role=" + role + ", userId=" + userId + "]";
    }

    public LoginResponse(String jwtToken, String name, String role, String userId) {
        this.jwtToken = jwtToken;
        this.name = name;
        this.role = role;
        this.userId = userId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getUserId() {
        return userId;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LoginResponse() {
    }
}
