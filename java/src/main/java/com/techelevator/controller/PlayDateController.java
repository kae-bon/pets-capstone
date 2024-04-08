package com.techelevator.controller;

import com.techelevator.dao.PlayDateDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.PlayDate;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
public class PlayDateController {
    private PlayDateDao playDateDao;
    public PlayDateController(PlayDateDao playDateDao) {
        this.playDateDao = playDateDao;
    }

    // TODO: need to add Pet play date connection
    @PostMapping("/playdates")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayDate createPlayDate(@RequestBody PlayDate newPlayDate) {
        try {
            return playDateDao.createPlayDate(newPlayDate);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Playdate registration failed.");
        }
    }
}
