package com.openclassroom.ApiChatop.service;


import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassroom.ApiChatop.model.Users;
import com.openclassroom.ApiChatop.repository.UsersRepository;


@Service("UsersService")
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
    public Users saveUser(Users users) {
        Users savedEmployee = UsersRepository.save(users);
        return savedEmployee;
    }

}