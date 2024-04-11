package com.techelevator.model;

import java.time.LocalDate;

public class Owner {

    private int id;

    public int getId() {
        return id;
    }

    private String lastName;
    private String firstName;
    private LocalDate birthdate;

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Owner(int id, String lastName, String firstName, LocalDate birthdate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
    }

    public Owner() {
    }
}
