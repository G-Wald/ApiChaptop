package com.openclassroom.ApiChatop.controller;

import com.openclassroom.ApiChatop.model.Messages;
import com.openclassroom.ApiChatop.model.Rentals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rentals")
public class MessagesController {
    @Autowired
    private com.openclassroom.ApiChatop.service.MessagesService MessagesService;
    /**
     * Read - Get all rentals
     * @return - An Iterable object of Employee fulfilled
     */
    @GetMapping("/{id}")
    public Iterable<Messages> getMessages() {
        return MessagesService.getMessages();
    }
}