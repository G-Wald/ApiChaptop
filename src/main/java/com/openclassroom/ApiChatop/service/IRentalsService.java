package com.openclassroom.ApiChatop.service;

import com.openclassroom.ApiChatop.model.Rentals;
import org.springframework.stereotype.Service;

@Service
public interface IRentalsService {
    public Iterable<Rentals> getRentals();
}