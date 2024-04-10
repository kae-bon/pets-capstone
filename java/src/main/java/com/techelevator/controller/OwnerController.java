package com.techelevator.controller;

import com.techelevator.dao.OwnerDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.UnderEighteenException;
import com.techelevator.model.Owner;
import com.techelevator.model.RegisterOwnerDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/owner")

public class OwnerController {

    private final OwnerDao ownerDao;

    public OwnerController(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterOwnerDto newOwner) {
        try {
            ownerDao.createOwner(newOwner);
        } catch (UnderEighteenException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create new owner.");
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Owner registration failed.");
        }
    }
    @PostMapping
    public Owner getByEmail(@RequestBody String email) {
        if (email == null || email.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is required.");
        }
        else {
            return ownerDao.getOwnerByEmail(email);
        }
    }



}
