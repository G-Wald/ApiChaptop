package com.openclassroom.ApiChatop.controller;


import com.openclassroom.ApiChatop.Utils.AuthTokenFilter;
import com.openclassroom.ApiChatop.Utils.JwtUtils;
import com.openclassroom.ApiChatop.model.JwtResponse;
import com.openclassroom.ApiChatop.model.LoginRequest;
import com.openclassroom.ApiChatop.model.Rentals;
import com.openclassroom.ApiChatop.model.Users;
import com.openclassroom.ApiChatop.provider.CustomAuthentificationProvider;
import com.openclassroom.ApiChatop.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    private UsersService UsersService;

    @Autowired
    private CustomAuthentificationProvider customAuthentificationprovider;

   @Autowired
   JwtUtils jwtUtils;

    @PostMapping("/auth/login")
    public ResponseEntity<?> Login(@RequestBody LoginRequest userLog){
        Authentication auth = customAuthentificationprovider.authenticate(new UsernamePasswordAuthenticationToken(userLog.getLogin(),userLog.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtUtils.generateJwtToken(auth);
      return ResponseEntity.ok(new JwtResponse(jwt, auth.getPrincipal().toString(),auth.getCredentials().toString()));
    }

    @GetMapping("/auth/me")
    public ResponseEntity<Users> getUser() {
        /*AuthTokenFilter authTokenFilter = new AuthTokenFilter();
        String jwt = authTokenFilter.parseJwt(request);
        var email = jwtUtils.getEmailFromJwtToken(jwt);
        var user = UsersService.GetUserByEmail(email);
        return ResponseEntity.ok(user.get());*/
        //Est il possible d'avoir le token avec un get ? Le mockoon ne retourne rien
        var user = new Users();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{id}")
    public Optional<Users> getUserById(@PathVariable String id) {
        return UsersService.getUser(id);
    }
}