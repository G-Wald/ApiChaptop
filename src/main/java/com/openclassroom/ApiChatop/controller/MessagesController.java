package com.openclassroom.ApiChatop.controller;

import com.openclassroom.ApiChatop.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private com.openclassroom.ApiChatop.service.MessagesService MessagesService;
    /**
     * Read - Post a Message
     * @return - An Message
     */
    @PostMapping("")
    public Messages createMessages(@RequestBody Messages messageSend) {
        Messages message = new Messages();
        message.setUser_id(messageSend.getUser_id());
        message.setRental_id(messageSend.getRental_id());
        message.setMessage(messageSend.getMessage());
        return MessagesService.saveMessage(message);
    }
}
