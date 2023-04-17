package com.openclassroom.ApiChatop.model;

public class JwtResponse {
    public String token;
    public String email;
    public String password;

    public JwtResponse(String token, String email, String password){
        this.email = email;
        this.token = token;
        this.password = password;
    }
}
