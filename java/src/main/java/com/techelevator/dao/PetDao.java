package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.RegisterPetDto;

import java.util.List;

public interface PetDao {

    List<Pet> getPets(int userId);

    Pet getPetById(int id);

    Pet getPetByPetname(String petName);

    Pet createPet(RegisterPetDto pet);



}
