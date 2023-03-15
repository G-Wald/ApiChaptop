package com.openclassroom.ApiChatop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.ApiChatop.model.users;

@Repository
public interface usersRepository extends CrudRepository<users,String> {

}
