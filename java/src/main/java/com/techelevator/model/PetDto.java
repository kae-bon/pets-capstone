package com.techelevator.model;

import java.time.LocalDate;

public class PetDto {
    private int id;
    private String name;
    private LocalDate birthdate;
    private String breed;
    private String size;
    private Boolean isFriendly;
    private int ownerId;
    private String profilePic;
    private String ownerFirstName;
    private String ownerLastName;

    public PetDto () {}
    public PetDto(int id, String name, LocalDate birthdate, String breed, String size, Boolean isFriendly, int ownerId, String profilePic, String ownerFirstName, String ownerLastName) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.breed = breed;
        this.size = size;
        this.isFriendly = isFriendly;
        this.ownerId = ownerId;
        this.profilePic = profilePic;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getFriendly() {
        return isFriendly;
    }

    public void setFriendly(Boolean friendly) {
        isFriendly = friendly;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }
}
