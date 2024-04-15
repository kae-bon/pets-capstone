package com.techelevator.model;

public class PetPlayDate {
    private int playDateId;
    private int petId;

    public int getPlayDateId() {
        return playDateId;
    }

    public int getPetId() {
        return petId;
    }

    public PetPlayDate(int playDateId, int petId) {
        this.playDateId = playDateId;
        this.petId = petId;
    }

    public PetPlayDate() {

    }

    public void setPlayDateId(int playDateId) {
        this.playDateId = playDateId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}
