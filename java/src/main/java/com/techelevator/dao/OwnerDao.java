package com.techelevator.dao;


import com.techelevator.model.Owner;
import com.techelevator.model.RegisterOwnerDto;
import com.techelevator.model.UpdateOwnerDto;

public interface OwnerDao {

    Owner createOwner(RegisterOwnerDto owner);

    Owner getOwnerByEmail(String email);

    Owner getOwnerById(int id);

    Owner updateOwner(Owner updatedOwner);
}
