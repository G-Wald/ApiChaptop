package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.users;
import org.springframework.stereotype.Service;

@Service
public interface IUsersService {
    public Iterable<users> getUsers();
}
