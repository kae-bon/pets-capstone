package com.techelevator.model;

import java.time.LocalDate;

public class RegisterOwnerDto {

    private int id;
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

    public RegisterOwnerDto() {
    }

}

