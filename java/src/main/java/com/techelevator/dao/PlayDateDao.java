package com.techelevator.dao;

import com.techelevator.model.PlayDate;

public interface PlayDateDao {
    /**
     * Method will create a new playdate using data passed in from the user to create a row in the database.
     * @param newPlayDate
     * @return A newly created play date
     */
    PlayDate createPlayDate(PlayDate newPlayDate);
    PlayDate getPlayDateById(int playDateId);
}
