package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Messages;
import org.springframework.stereotype.Service;

@Service
public interface IMessagesService {
    public Iterable<Messages> getMessages();
}