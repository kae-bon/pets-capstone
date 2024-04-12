package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
}
