package com.openclassroom.ApiChatop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.ApiChatop.model.Users;
import com.openclassroom.ApiChatop.service.UsersService;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UsersController {
    @Autowired
    private UsersService UsersService;
    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    public Iterable<Users> getUsers() {

        return UsersService.getUsers();
    }

    @GetMapping
    public Users retrievePrincipal(Users user) {
        return user;
    }

    @GetMapping("/{id}")
    public Optional<Users> getUser(String id) {
        return UsersService.getUser(id);
    }
}