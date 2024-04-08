package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pet;
import com.techelevator.model.RegisterPetDto;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcPetDao implements PetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Pet> getPets() {
        return null;
    }

    @Override
    public Pet getPetById(int id) {
        return null;
    }

    @Override
    public Pet getPetByPetname(String petName) {
        Pet pet = null;
        String sql = "SELECT name, owner_id, birthdate, breed, size, isFriendly " +
                "WHERE name = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petName);
            while (results.next()) {
                pet = mapRowToPet(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return pet;
    }



    @Override
    public Pet createPet(RegisterPetDto pet) {
        Pet newPet = null;
        String sql = "INSERT INTO pets(name, owner_id, birthdate, breed, size, isFriendly)";
        try {
            int newPetId = jdbcTemplate.queryForObject(sql, int.class, pet.getPetName(), pet.getOwnerId(), pet.getBirthdate(), pet.getBreed(), pet.getSize(), pet.getFriendly());
            newPet = getPetById(newPetId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return newPet;
    }

    private Pet mapRowToPet(SqlRowSet results) {
        Pet pet = new Pet();
        pet.setId(results.getInt("pet_id"));
        pet.setName(results.getString("name"));
        pet.setOwnerId(results.getInt("owner_id"));
        pet.setAge(results.getInt("birthdate"));
        pet.setBreed(results.getString("breed"));
        pet.setSize(results.getString("size"));
        pet.setFriendly(results.getBoolean("isFriendly"));


        return pet;
    }

}
