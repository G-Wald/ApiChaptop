package com.openclassroom.ApiChatop.controller;

import com.openclassroom.ApiChatop.model.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private com.openclassroom.ApiChatop.service.MessagesService MessagesService;

    @PostMapping("")
    public String createMessages(@RequestBody Messages messageSend) {
        Messages message = new Messages();
        message.setUser_id(messageSend.getUser_id());
        message.setRental_id(messageSend.getRental_id());
        message.setMessage(messageSend.getMessage());
        var savedMessage = MessagesService.saveMessage(message);

        if(savedMessage == null){
            return null;
        }
        return "Message send with success";
    }
}
