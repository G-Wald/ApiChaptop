package com.openclassroom.ApiChatop.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.ApiChatop.model.Users;

@Qualifier("Users")
@Repository
public interface UsersRepository extends CrudRepository<Users,String> {

}
