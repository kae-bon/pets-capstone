package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.exception.DuplicatePetException;
import com.techelevator.model.Pet;
import com.techelevator.model.RegisterPetDto;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcPetDao implements PetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SELECT_SQL = "SELECT pet_id, name, owner_id, birthdate, breed, size, isFriendly FROM pets ";



    @Override
    public List<Pet> getPets( int userId) {
        List<Pet> pets = new ArrayList<>();
        String sql = SELECT_SQL + "WHERE owner_id = ?;";

        try {

            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
            while (rowSet.next()) {
                Pet pet = mapRowToPet(rowSet);
                pets.add(pet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the database", e);
        }
        return pets;
    }

    @Override
    public Pet getPetById(int id) {
        Pet pet = null;
        String sql = SELECT_SQL + "WHERE pet_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
            while (rowSet.next()) {
                pet = mapRowToPet(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the database", e);
        }
        return pet;

    }

    @Override
    public Pet getPetByPetname(String petName) {
        Pet pet = null;
        String sql = SELECT_SQL + "WHERE name = ?;";
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
        String sql = "INSERT INTO pets(name, owner_id, birthdate, breed, size, isFriendly) values(?, ?, ?, ?, ?, ?) RETURNING pet_id;";
        try {
            int newPetId = jdbcTemplate.queryForObject(
                    sql,
                    int.class, pet.getPetName(),
                    pet.getOwnerId(),
                    pet.getBirthdate(),
                    pet.getBreed(),
                    pet.getSize(),
                    pet.getFriendly());
            newPet = getPetById(newPetId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicatePetException("Pet already exists in database", e);
        } catch (DataAccessException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newPet;
    }

    private Pet mapRowToPet(SqlRowSet results) {
        Pet pet = new Pet();
        pet.setId(results.getInt("pet_id"));
        pet.setName(results.getString("name"));
        pet.setOwnerId(results.getInt("owner_id"));
        pet.setBirthdate(results.getDate("birthdate").toLocalDate());
        pet.setBreed(results.getString("breed"));
        pet.setSize(results.getString("size"));
        pet.setFriendly(results.getBoolean("isFriendly"));


        return pet;
    }

}
