package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Rentals;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("RentalsService")
public class RentalsService implements IRentalsService {

    @Autowired
    private com.openclassroom.ApiChatop.repository.RentalsRepository RentalsRepository;

    @Transactional
    public Optional<Rentals> getRental(final String id) {
        return RentalsRepository.findById(id);
    }

    @Transactional
    public Iterable<Rentals> getRentals() {
        return RentalsRepository.findAll();
    }

    @Transactional
    public void deleteRental(final String id) {
        RentalsRepository.deleteById(id);
    }

    @Transactional
    public Rentals saveRental(Rentals rentals) {
        Rentals savedRental = RentalsRepository.save(rentals);
        return savedRental;
    }

}