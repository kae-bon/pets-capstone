package com.techelevator.model;

import java.security.Principal;
import java.time.LocalDate;

public class UpdateOwnerDto {

    private int id;
    private String lastName;
    private String firstName;
    private LocalDate birthdate;
    private String profilePic;
    private String email;

    public UpdateOwnerDto() {
    }

    public UpdateOwnerDto(int id, String lastName, String firstName, LocalDate birthdate, String profilePic, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.profilePic = profilePic;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}