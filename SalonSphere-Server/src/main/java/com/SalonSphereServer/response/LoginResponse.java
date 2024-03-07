package com.SalonSphereServer.response;

import lombok.Builder;

@Builder
public class LoginResponse {

    private String jwtToken;
    private String email;

    public LoginResponse() {
    }

    public LoginResponse(String jwtToken, String email) {
        this.jwtToken = jwtToken;
        this.email = email;
    }
        
    public String getjwtToken() {
        return jwtToken;
    }

  public void setjwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "JWTResponse [jwtToken=" + jwtToken + ", email=" + email + "]";
    }
}
