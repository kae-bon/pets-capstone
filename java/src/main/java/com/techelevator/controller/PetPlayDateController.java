package com.techelevator.controller;

import com.techelevator.dao.PlayDateDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Pet;
import com.techelevator.model.PetPlayDate;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PetPlayDateController {
    private PlayDateDao playDateDao;

    public PetPlayDateController(PlayDateDao playDateDao) {
        this.playDateDao = playDateDao;
    }

    @PostMapping("/playdates/pets")
    public void addPetsToPlayDate(@RequestBody List<PetPlayDate> petPlayDates) {
        try {
            for (PetPlayDate petPlayDate : petPlayDates) {
                playDateDao.insertPetPlayDate(petPlayDate.getPetId(), petPlayDate.getPlayDateId());
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Couldn't add pet to play date.");
        }
    }



}
