package com.openclassroom.ApiChatop.controller;

import com.openclassroom.ApiChatop.model.Rentals;
import com.openclassroom.ApiChatop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/rentals")
public class RentalsController {
    @Autowired
    private com.openclassroom.ApiChatop.service.RentalsService RentalsService;
    /**
     * Read - Get all rentals
     * @return - An Iterable object of Employee fulfilled
     */
   /* @GetMapping("")
    public Iterable<Rentals> getRentals() {
        return RentalsService.getRentals();
    }*/

    @GetMapping("/{id}")
    public Optional<Rentals> getRental(@PathVariable String id) {
        return RentalsService.getRental(id);
    }
}