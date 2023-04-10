package com.openclassroom.ApiChatop.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.ApiChatop.model.Users;

import java.util.Optional;

@Qualifier("Users")
@Repository
public interface UsersRepository extends CrudRepository<Users,String>, JpaRepository<Users,String> {

    @Query("SELECT u FROM Users u WHERE u.name = ?1")
    Optional<Users> findByName(String name);
}
