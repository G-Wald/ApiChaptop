package com.openclassroom.ApiChatop.controller;

import com.openclassroom.ApiChatop.model.Rentals;
import com.openclassroom.ApiChatop.service.FileSystemStorageService;
import com.openclassroom.ApiChatop.service.RentalsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalsController {
    Logger logger = LoggerFactory.getLogger(RentalsController.class);
    private final RentalsService rentalsService;

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

   @GetMapping
    public Iterable<Rentals> getRentals() {
        return rentalsService.getRentals();
    }

    @GetMapping("/{id}")
    public Optional<Rentals> getRental(@PathVariable String id) {
       return rentalsService.getRental(id);
    }

    @PostMapping("/{id}")
    public String createRental(@PathVariable String id,
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
        rental.setPicture(fileSystemStorageService.store(rental, picture));
        if( rentalsService.saveRental(rental) == null){
            return null;
        }
        return "Rental created !";
    }


    @PutMapping("/{id}")
    public String updateRental(@PathVariable String id,
                                @RequestParam("name") String name,
                                @RequestParam("surface") int surface,
                                @RequestParam("price") int price,
                                @RequestParam("description") String description
    ){
        Optional<Rentals> rental = rentalsService.getRental(id);
        rental.get().setName(name);
        rental.get().setSurface(surface);
        rental.get().setPrice(price);
        rental.get().setDescription(description);
        DateConverter converter = new DateConverter();
        rental.get().setUpdated_at(converter.convertToDateViaInstant(LocalDate.now()));
        if( rentalsService.updateRental(rental.get()) == null){
            return null;
        }
        return "Rental updated !";
    }
}