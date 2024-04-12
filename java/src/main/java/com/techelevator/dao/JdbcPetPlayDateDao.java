package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.PetPlayDate;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcPetPlayDateDao implements PetPlayDateDao {
    private final JdbcTemplate jdbc;
    public JdbcPetPlayDateDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    // write tests for this once we have the pet model information - COME BACK TO THIS!!!!!!!!!
    @Override
    public void insertPetPlayDate(int petId, int playDateId) {
        String sql = "INSERT INTO pet_play_dates(play_date_id, pet_id)\n" +
                "VALUES (?, ?);";
        try {
            jdbc.update(sql, playDateId, petId);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
    }

    public List<PetPlayDate> getPetPlayDates() {
        String sql = "SELECT play_date_id, pet_id\n" +
                "\tFROM pet_play_dates;";
        List<PetPlayDate> petPlayDates = new ArrayList<>();
        try {
            SqlRowSet results = this.jdbc.queryForRowSet(sql);
            while (results.next()) {
                PetPlayDate petPlayDate = new PetPlayDate();
                petPlayDate.setPetId(results.getInt("pet_id"));
                petPlayDate.setPlayDateId(results.getInt("play_date_id"));
                petPlayDates.add(petPlayDate);
            }
            return petPlayDates;
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
    }
}
