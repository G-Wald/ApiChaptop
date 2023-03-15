package com.openclassroom.ApiChatop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.ApiChatop.model.users;
import com.openclassroom.ApiChatop.service.usersService;

@RestController
public class usersController {
	
    @Autowired
    private usersService usersService;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("/users")
    public Iterable<users> getusers() {
        return usersService.getusers();
    }

}