package com.example.springsecurityjwt.model;

public class AuthenicationResponse {
    private String jwt;

    public AuthenicationResponse() {
    }

    public AuthenicationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
