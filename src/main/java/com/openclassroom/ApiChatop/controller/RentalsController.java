package com.openclassroom.ApiChatop.controller;

import com.openclassroom.ApiChatop.model.Rentals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rentals")
public class RentalsController {
    @Autowired
    private com.openclassroom.ApiChatop.service.RentalsService RentalsService;
    /**
     * Read - Get all rentals
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/{id}")
    public Iterable<Rentals> getRentals() {
        return RentalsService.getRentals();
    }
}