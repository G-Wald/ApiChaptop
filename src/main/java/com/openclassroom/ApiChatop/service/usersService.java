package com.openclassroom.ApiChatop.service;


import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassroom.ApiChatop.model.users;
import com.openclassroom.ApiChatop.repository.usersRepository;

import lombok.Data;


@Service("usersService")
public class usersService implements IUsersService {

    @Autowired
    private usersRepository usersRepository;

    @Transactional
    public Optional<users> getUser(final String id) {
        return usersRepository.findById(id);
    }

    @Transactional
    public Iterable<users> getUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    public void deleteUser(final String id) {
        usersRepository.deleteById(id);
    }

    @Transactional
    public users saveUser(users users) {
        users savedEmployee = usersRepository.save(users);
        return savedEmployee;
    }

}