package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Messages;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service("MessagesService")
public class MessagesService implements IMessagesService {

    @Autowired
    private com.openclassroom.ApiChatop.repository.MessagesRepository MessagesRepository;

    @Transactional
    public Optional<Messages> getMessage(final String id) {
        return MessagesRepository.findById(id);
    }

    @Transactional
    public Iterable<Messages> getMessages() {
        return MessagesRepository.findAll();
    }

    @Transactional
    public void deleteMessage(final String id) {
        MessagesRepository.deleteById(id);
    }

    @Transactional
    public Messages saveMessage(Messages messages) {
        Messages savedMessage = MessagesRepository.save(messages);
        return savedMessage;
    }

}