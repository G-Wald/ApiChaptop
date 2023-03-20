package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Users;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUsersService {
    public Iterable<Users> getUsers();

    public Optional<Users> getUser(String id);
}
