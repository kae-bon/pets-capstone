package com.techelevator.dao;

import com.techelevator.model.PetPlayDate;

import java.util.List;

public interface PetPlayDateDao {

    /**
     * Method will insert a row into the Pet Play Date table, containing the pet ID and the play date ID, to
     * link the pet and the play date
     * @param petId id of pet registering for play date
     * @param playDateId id of play date
     */
    void insertPetPlayDate(int petId, int playDateId);
    public List<PetPlayDate> getPetPlayDates();
}
