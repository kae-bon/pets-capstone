package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.DuplicatePetException;
import com.techelevator.model.Pet;
import com.techelevator.model.RegisterPetDto;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/owner")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PetController {

    private final PetDao petDao;
    private final UserDao userDao;

    public PetController(PetDao petDao, UserDao userDao) {
        this.petDao = petDao;
        this.userDao = userDao;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/pet/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterPetDto newPet) {
        try {
            petDao.createPet(newPet);
        } catch (DuplicatePetException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pet already exists");
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Pet registration failed.");
        }
    }

    @GetMapping(path = "/pets")
    public List<Pet> getUserPets(Principal user) {
        try {
            User owner = userDao.getUserByUsername(user.getName());
            int userId = owner.getId();
            return petDao.getPets(userId);
        } catch (DuplicatePetException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pet already exists");
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Pet registration failed.");
        }
    }

}
