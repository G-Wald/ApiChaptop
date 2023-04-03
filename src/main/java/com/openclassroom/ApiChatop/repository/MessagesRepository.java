package com.openclassroom.ApiChatop.repository;

import com.openclassroom.ApiChatop.model.Messages;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier("Messages")
@Repository
public interface MessagesRepository extends CrudRepository<Messages,String> {
    Optional<Messages> findById(String id);
    Messages save(Messages messages);
}