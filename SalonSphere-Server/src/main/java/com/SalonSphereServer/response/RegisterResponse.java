package com.SalonSphereServer.response;

public class RegisterResponse {
    private String response;

    public void setResponse(String response) {
        this.response = response;
    }

    public RegisterResponse() {
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "RegisterResponse [response=" + response + "]";
    }

    public RegisterResponse(String response) {
        this.response = response;
    }
    
}
