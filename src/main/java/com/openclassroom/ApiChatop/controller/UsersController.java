package com.openclassroom.ApiChatop.controller;


import com.openclassroom.ApiChatop.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*@PostMapping("login")
    public Users Login(@RequestBody Users userLog){

    }*/

    @GetMapping("/{id}")
    public Optional<Users> getUser(String id) {
        return UsersService.getUser(id);
    }
}