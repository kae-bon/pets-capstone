package com.techelevator.controller;

import com.techelevator.dao.PlayDateDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.PlayDate;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PlayDateController {
    private PlayDateDao playDateDao;
    private UserDao userDao;
    public PlayDateController(PlayDateDao playDateDao, UserDao userDao) {
        this.playDateDao = playDateDao;
        this.userDao = userDao;
    }

    // TODO: need to add Pet play date connection
    @PostMapping("/playdates")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayDate createPlayDate(@RequestBody PlayDate newPlayDate, Principal user) {
        try {
            User owner = userDao.getUserByUsername(user.getName());
            int userId = owner.getId();
            newPlayDate.setHostId(userId);
            return playDateDao.createPlayDate(newPlayDate);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Playdate registration failed.");
        }
    }
}
