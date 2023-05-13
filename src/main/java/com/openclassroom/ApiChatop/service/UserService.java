package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.auth.AuthenticationRequest;
import com.openclassroom.ApiChatop.auth.AuthenticationResponse;
import com.openclassroom.ApiChatop.auth.RegisterRequest;
import com.openclassroom.ApiChatop.auth.UserDetailResponse;
import com.openclassroom.ApiChatop.model.Rentals;
import com.openclassroom.ApiChatop.repository.UserRepository;
import com.openclassroom.ApiChatop.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    //Add a user in db
    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        if(repository.findByEmail(user.getEmail()).isPresent()){
            return null;
        }

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    //Check the request contain valid email and password and return a token
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public UserDetailResponse getUserFromHeaders(Map<String, String> headers) {
        String authHeader = headers.get("authorization");
        var jwtToken = authHeader.substring(7);
        var email = jwtService.extractUsername(jwtToken);
        var user = repository.findByEmail(email);
        return UserDetailResponse.builder()
                .id(user.get().getId())
                .name(user.get().getName())
                .email(user.get().getEmail())
                .created_at(user.get().getCreated_at().toString())
                .updated_at(user.get().getUpdated_at().toString())
                .build();
    }

    public UserDetailResponse getUserById(final String id) {
        var user = repository.findById(id);

        if(user.isEmpty()){
            return null;
        }

        UserDetailResponse userDetailResponse = new UserDetailResponse();
        userDetailResponse.setId(user.get().getId());
        userDetailResponse.setName(user.get().getName());
        userDetailResponse.setEmail(user.get().getEmail());
        userDetailResponse.setCreated_at(user.get().getCreated_at().toString());
        userDetailResponse.setUpdated_at(user.get().getUpdated_at().toString());

        return userDetailResponse;
    }
}