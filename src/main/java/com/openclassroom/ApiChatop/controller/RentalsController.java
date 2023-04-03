package com.openclassroom.ApiChatop.controller;

import com.openclassroom.ApiChatop.model.Rentals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Optional;

import static java.lang.Integer.parseInt;


@RestController
@RequestMapping("/rentals")
public class RentalsController {
    Logger logger = LoggerFactory.getLogger(RentalsController.class);
    @Autowired
    private com.openclassroom.ApiChatop.service.RentalsService RentalsService;
    /**
     * Read - Get all rentals
     * @return - An Iterable object of Employee fulfilled
     */


   @GetMapping("")
    public Iterable<Rentals> getRentals() {
       logger.debug("call of getRentals method");
        return RentalsService.getRentals();
    }

    @GetMapping("/{id}")
    public Optional<Rentals> getRental(@PathVariable String id) {
        return RentalsService.getRental(id);
    }

    @PostMapping("/{id}")
    public Rentals createRental(@PathVariable String id,
                                @RequestParam("name") String name,
                                @RequestParam("surface") int surface,
                                @RequestParam("price") int price,
                                @RequestParam("picture") MultipartFile picture,
                                @RequestParam("description") String description
                                ){
        Rentals rental = new Rentals();
        rental.setName(name);
        rental.setSurface(surface);
        rental.setPrice(price);
        rental.setDescription(description);
        rental.setOwner_id(id);
        rental.setPicture("testpictureurl");
        return RentalsService.saveRental(rental);
    }

    @PutMapping(value = "/{id}")
    public Rentals updateRental(@PathVariable String id,
                                @RequestParam("name") String name,
                                @RequestParam("surface") int surface,
                                @RequestParam("price") int price,
                                @RequestParam("description") String description
    ){
        Optional<Rentals> rental = RentalsService.getRental(id);
        rental.get().setName(name);
        rental.get().setSurface(surface);
        rental.get().setPrice(price);
        rental.get().setDescription(description);
        DateConverter converter = new DateConverter();
        rental.get().setUpdated_at(converter.convertToDateViaInstant(LocalDate.now()));
        return RentalsService.updateRental(rental.get());
    }
}