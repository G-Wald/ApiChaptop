package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface IUsersService {
    public Iterable<Users> getUsers();
}
