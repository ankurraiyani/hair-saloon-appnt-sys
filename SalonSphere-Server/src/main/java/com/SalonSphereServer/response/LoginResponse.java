package com.SalonSphereServer.response;

import lombok.Builder;

@Builder
public class LoginResponse {

    private String jwtToken;
    private String name;
    private String role;
    
    public String getJwtToken() {
        return jwtToken;
    }
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LoginResponse() {
    }
    public LoginResponse(String jwtToken, String name, String role) {
        this.jwtToken = jwtToken;
        this.name = name;
        this.role = role;
    }
    @Override
    public String toString() {
        return "LoginResponse [jwtToken=" + jwtToken + ", name=" + name + ", role=" + role + "]";
    }


    }
