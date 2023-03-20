package com.openclassroom.ApiChatop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.ApiChatop.model.Users;
import com.openclassroom.ApiChatop.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService UsersService;
    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/{id}")
    public Iterable<Users> getUsers() {
        return UsersService.getUsers();
    }
}