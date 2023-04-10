package com.openclassroom.ApiChatop.provider;

import com.openclassroom.ApiChatop.model.Users;
import com.openclassroom.ApiChatop.repository.UsersRepository;
import com.openclassroom.ApiChatop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthentificationProvider implements AuthenticationProvider {



    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
      String name = authentication.getName();
      String password = authentication.getCredentials().toString();

      Users user = usersService.findByName(name).orElseThrow(()->
              new UsernameNotFoundException("User not found"));

      if(password.equals(user.getPassword())){
          return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
      }else {
          throw new BadCredentialsException("Invalid credentials");
      }
    }
//passwordEncoder.matches(password,user.getPassword())
    @Override
    public boolean supports(Class<?>authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}