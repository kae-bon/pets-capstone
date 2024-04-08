package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDao {

    List<Pet> getPets();

    Pet getPetById(int id);

    Pet getPetByPetname(String petName);

    Pet createPet(RegisterPetDto pet);



}
