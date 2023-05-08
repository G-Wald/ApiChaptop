package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Rentals;
import com.openclassroom.ApiChatop.repository.RentalsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RentalsService implements IRentalsService {

    private final RentalsRepository rentalsRepository;

    @Transactional
    public Optional<Rentals> getRental(final String id) {
        return rentalsRepository.findById(id);
    }

    public Iterable<Rentals> getRentals() {
        return rentalsRepository.findAll();
    }

    @Transactional
    public Rentals saveRental(Rentals rental) {
        Rentals savedRental = rentalsRepository.save(rental);
        return savedRental;
    }

    @Transactional
    public Rentals updateRental(Rentals rental) {
        Rentals newRental = rentalsRepository.save(rental);
        return newRental;
    }

    @Transactional
    public void deleteRental(final String id) {
        rentalsRepository.deleteById(id);
    }
}