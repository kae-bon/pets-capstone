package com.techelevator.dao;

import com.techelevator.model.PlayDate;

import java.util.List;

public interface PlayDateDao {
    /**
     * Method will create a new playdate using data passed in from the user to create a row in the database.
     * @param newPlayDate newly created play date, without an assigned id, to be sent to database
     * @return A newly created play date
     */
    PlayDate createPlayDate(PlayDate newPlayDate);
    /**
     * Method will return the associated play date by the provided play date id
     * @param playDateId play date id of play date to retrieve
     * @return the retrieved play date
     */
    PlayDate getPlayDateById(int playDateId);


    /**
     * Method will return all upcoming play dates
     * will need to be updated to return play dates specific to a petId once that is implemented
     * @return
     */
    List<PlayDate> getUpcomingPlayDates();

    List<PlayDate> getUserPlayDates(int userId);


}
