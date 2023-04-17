package com.openclassroom.ApiChatop.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginRequest {

    private String login;
    private String password;

    public LoginRequest(){};

    public String getLogin(){
        return this.login;
    }

    public String getPassword(){
        return this.password;
    }
}
