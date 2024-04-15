package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.PlayDateDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Pet;
import com.techelevator.model.PlayDate;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PlayDateController {
    private PlayDateDao playDateDao;
    private PetDao petDao;
    private UserDao userDao;
    public PlayDateController(PlayDateDao playDateDao, UserDao userDao, PetDao petDao) {
        this.playDateDao = playDateDao;
        this.userDao = userDao;
        this.petDao = petDao;
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


    @GetMapping("/playdates")
    public List<PlayDate> getUpcomingPlayDates(@RequestParam(value = "host_id", required = false) Integer userId, Principal user) {
        List<PlayDate> playDates = new ArrayList<>();
        if (userId != null) {
            User host = userDao.getUserByUsername(user.getName());
            int host_id = host.getId();
            playDates = this.playDateDao.getUserPlayDates(host_id);
            this.mapPetsToPlayDates(playDates);
            return playDates;
        }
        playDates = this.playDateDao.getUpcomingPlayDates();
        mapPetsToPlayDates(playDates);
        return playDates;
    }

    @GetMapping("/playdates/{playDateId}")
    public PlayDate getPlayDateById(@PathVariable("playDateId") Integer playDateId) {
        PlayDate playDate = this.playDateDao.getPlayDateById(playDateId);
        List<Pet> playDatePets = this.petDao.getPlayDatePets(playDateId);
        playDate.setAttendingPets(playDatePets);
        return playDate;
    }

    public void mapPetsToPlayDates(List<PlayDate> playDates) {
        for( PlayDate playDate : playDates) {
            List<Pet> playdatePets = petDao.getPlayDatePets(playDate.getPlayDateId());
            playDate.setAttendingPets(playdatePets);
        }
    }
}
