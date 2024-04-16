package com.techelevator.controller;

import com.techelevator.dao.OwnerDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.UnderEighteenException;
import com.techelevator.model.Owner;
import com.techelevator.model.RegisterOwnerDto;
import com.techelevator.model.UpdateOwnerDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/owners")
@CrossOrigin

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
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}")
    public Owner getOwnerById(@PathVariable int id) {
        Owner owner = ownerDao.getOwnerById(id);
        if (owner == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found.");
        }
        return owner;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}")
    public Owner updateOwner(@RequestBody @Valid Owner updatedOwner, @PathVariable int id) {
       try {
           updatedOwner.setId(id);
           updatedOwner= ownerDao.updateOwner(updatedOwner);
       } catch (DaoException e) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found.");
       }
       return updatedOwner;

        }


}
