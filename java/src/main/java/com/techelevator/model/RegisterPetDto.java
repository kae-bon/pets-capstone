package com.techelevator.model;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

/*
    The acronym DTO is being used for "data transfer object". It means that this type of class is specifically
    created to transfer data between the client and the server. For example, CredentialsDto represents the data a client must
    pass to the server for a login endpoint, and TokenDto represents the object that's returned from the server
    to the client from a login endpoint.
 */

public class RegisterPetDto {

    @NotEmpty
    private String petName;

    @NotEmpty
    private int ownerId;

    @NotEmpty 
    private String profilePicture;

    @NotEmpty
    private LocalDate birthdate;

    @NotEmpty
    private String breed;

    @NotEmpty
    private String size;

    @NotEmpty
    private Boolean isFriendly;


}
