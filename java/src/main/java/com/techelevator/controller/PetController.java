package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.RegisterPetDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



import javax.validation.Valid;

@RestController
@RequestMapping(path = "/pet")
@PreAuthorize("isAuthenticated()")

public class PetController {

    private PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterPetDto newPet) {
        try {
            if (petDao.getPetByPetname(newPet.getPetName()) != null) {
                //TODO:
                // 1. Get pets associated with owner
                // 2. Verify that pet doesn't already exist
                // 3. Uniqueness is defined by pet.name + pet.birthdate + pet.breed + pet.ownerId
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PetName already exists.");
            } else {
                petDao.createPet(newPet);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Pet registration failed.");
        }
    }
}
