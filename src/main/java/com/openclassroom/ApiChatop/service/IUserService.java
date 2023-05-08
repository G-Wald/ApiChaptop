package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.auth.AuthenticationRequest;
import com.openclassroom.ApiChatop.auth.AuthenticationResponse;
import com.openclassroom.ApiChatop.auth.RegisterRequest;
import com.openclassroom.ApiChatop.model.User;

import java.util.Optional;

public interface IUserService {
    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);
    public Optional<User> getUserFromToken(String id);
}
