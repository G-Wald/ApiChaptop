package com.openclassroom.ApiChatop.repository;

import com.openclassroom.ApiChatop.model.Rentals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalsRepository extends CrudRepository<Rentals,String> {
    List<Rentals> findAll();
    Optional<Rentals> findById(String id);
    Rentals save(Rentals rental);
}