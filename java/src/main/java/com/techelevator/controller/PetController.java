package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.exception.DaoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

public class PetController {

    private PetDao petDao;

    @RequestMapping(path = "/pet/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterPetDto newPet) {
        try {
            if (petDao.getPetByPetname(newPet.getPetname()) != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Petname already exists.");
            } else {
                petDao.createPet(newPet);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Pet registration failed.");
        }
    }
}
