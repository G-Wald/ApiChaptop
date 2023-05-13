package com.openclassroom.ApiChatop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.openclassroom.ApiChatop.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(String id);
}
