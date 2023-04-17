package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.provider.CustomAuthentificationProvider;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.openclassroom.ApiChatop.model.Users;
import com.openclassroom.ApiChatop.repository.UsersRepository;

import java.util.Optional;


@Service()
public class UsersService implements IUsersService {
    @Autowired
    private UsersRepository UsersRepository;

    @Transactional
    public Optional<Users> getUser(final String id) {
        return UsersRepository.findById(id);
    }

    @Transactional
    public Iterable<Users> getUsers() {
        return UsersRepository.findAll();
    }

    @Transactional
    public void deleteUser(final String id) {
        UsersRepository.deleteById(id);
    }

    @Transactional
    public Optional<Users> GetUserByEmail(final String email) {
        return UsersRepository.findByEmail(email);
    }

    //@Transactional
    //public String login(Users user){

      //  Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        //return customAuthentificationprovider.authenticate(auth).getDetails().toString();
    //}

    @Transactional
    public Users saveUser(Users users) {
        return UsersRepository.save(users);
    }

    @Transactional
    public Optional<Users> findByName(String name){
        Optional<Users> user = UsersRepository.findByName(name);
        return user;
    }
}