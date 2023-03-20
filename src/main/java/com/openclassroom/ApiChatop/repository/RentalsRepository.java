package com.openclassroom.ApiChatop.repository;

import com.openclassroom.ApiChatop.model.Rentals;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("Rentals")
@Repository
public interface RentalsRepository extends CrudRepository<Rentals,String> {
}