package com.openclassroom.ApiChatop.provider;

import com.openclassroom.ApiChatop.model.Users;
import com.openclassroom.ApiChatop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Component
public class CustomAuthentificationProvider implements AuthenticationProvider {

    @Autowired
    private UsersService usersService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
      String email = authentication.getPrincipal().toString();
      String password = authentication.getCredentials().toString();

      if(StringUtils.isEmpty(email)||StringUtils.isEmpty(password)){
          throw new BadCredentialsException("One of the login is empty");
      }

      Users user = usersService.GetUserByEmail(email).orElseThrow(()->
              new UsernameNotFoundException("User not found"));

      if(password.equals(user.getPassword())){
          return createSuccessfulAuthentification(authentication, email, password);
      }else {
          throw new BadCredentialsException("No match for password");
      }
    }

    private Authentication createSuccessfulAuthentification(final Authentication auth, String email, String password){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password, new ArrayList<>());
        token.setDetails(auth.getDetails());
        return token;


    }

//passwordEncoder.matches(password,user.getPassword())
    @Override
    public boolean supports(Class<?>authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
