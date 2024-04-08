package com.techelevator.model;

import java.time.LocalDate;
import java.util.Objects;

public class Pet {
    private int id;
    private String name;
    private LocalDate birthdate;
    private String breed;
    private String size;
    private Boolean isFriendly;
    private int ownerId;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    private String profilePicture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return ownerId == pet.ownerId && Objects.equals(name, pet.name) && Objects.equals(birthdate, pet.birthdate) && Objects.equals(breed, pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, breed, ownerId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setFriendly(Boolean friendly) {
        isFriendly = friendly;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Pet(int id, String name, LocalDate birthdate, String breed, String size, Boolean isFriendly, int ownerId) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.breed = breed;
        this.size = size;
        this.isFriendly = isFriendly;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public String getSize() {
        return size;
    }

    public Boolean getFriendly() {
        return isFriendly;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public Pet() {

    }
}


