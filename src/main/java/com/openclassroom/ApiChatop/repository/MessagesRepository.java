package com.openclassroom.ApiChatop.repository;

import com.openclassroom.ApiChatop.model.Messages;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("Messages")
@Repository
public interface MessagesRepository extends CrudRepository<Messages,String> {
}