package com.techelevator.controller;

import com.techelevator.dao.PetPlayDateDao;
import com.techelevator.dao.PlayDateDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Pet;
import com.techelevator.model.PetPlayDate;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PetPlayDateController {
    private PetPlayDateDao petPlayDateDao;

    public PetPlayDateController(PetPlayDateDao petPlayDateDao) {
        this.petPlayDateDao = petPlayDateDao;
    }

    @PostMapping("/playdates/pets")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addPetsToPlayDate(@RequestBody List<PetPlayDate> petPlayDates) {
        try {
            for (PetPlayDate petPlayDate : petPlayDates) {
                petPlayDateDao.insertPetPlayDate(petPlayDate.getPetId(), petPlayDate.getPlayDateId());
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Couldn't add pet to play date.");
        }
    }

    @GetMapping("/playdates")
    public List<PetPlayDate> getAllPetPlayDates() {
        try {
            return this.petPlayDateDao.getPetPlayDates();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Couldn't retrieve playdates.");
        }
    }
}
