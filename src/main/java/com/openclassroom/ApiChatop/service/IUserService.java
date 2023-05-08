package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.auth.AuthenticationRequest;
import com.openclassroom.ApiChatop.auth.AuthenticationResponse;
import com.openclassroom.ApiChatop.auth.RegisterRequest;
import com.openclassroom.ApiChatop.auth.UserDetailResponse;

import java.util.Map;

public interface IUserService {
    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);
    public UserDetailResponse getUserFromHeaders(Map<String,String> headers);
}
