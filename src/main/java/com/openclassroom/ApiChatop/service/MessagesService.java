package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Messages;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagesService implements IMessagesService {

    @Autowired
    private com.openclassroom.ApiChatop.repository.MessagesRepository MessagesRepository;

    @Transactional
    public Messages saveMessage(Messages messages) {
        Messages savedMessage = MessagesRepository.save(messages);
        return savedMessage;
    }
}