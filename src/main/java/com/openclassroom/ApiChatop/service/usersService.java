package com.openclassroom.ApiChatop.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassroom.ApiChatop.model.users;
import com.openclassroom.ApiChatop.repository.usersRepository;

import lombok.Data;

@Data
@Service
public class usersService implements IUsersService {

    @Autowired
    private usersRepository usersRepository;

    public Optional<users> getUser(final String id) {

        return usersRepository.findById(id);
    }

    public Iterable<users> getUsers() {

        return usersRepository.findAll();
    }

    public void deleteUser(final String id) {

        usersRepository.deleteById(id);
    }

    public users saveUser(users users) {
        users savedEmployee = usersRepository.save(users);
        return savedEmployee;
    }

}