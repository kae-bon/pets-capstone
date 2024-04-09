package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Owner;
import com.techelevator.model.RegisterOwnerDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcOwnerDao implements OwnerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOwnerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SELECT_SQL = "SELECT owner_id, first_name, last_name, birthdate, email FROM owners ";


    @Override
    public Owner createOwner(RegisterOwnerDto owner) {
        Owner newOwner = null;
        String sql = "INSERT INTO owners(first_name, last_name, birthdate, email) values(?, ?, ?, ?) RETURNING owner_id;";
        try {
            int newOwnerId = jdbcTemplate.queryForObject(
                    sql,
                    int.class, owner.getFirstName(),
                    owner.getLastName(),
                    owner.getBirthdate(),
                    owner.getEmail());
            newOwner = getNewOwnerById(newOwnerId);
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataAccessException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newOwner;
    }

    private Owner getNewOwnerById(int newOwnerId) {
        Owner owner = null;
        String sql = SELECT_SQL + "WHERE owner_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
            while (rowSet.next()) {
                owner = mapRowToOwner(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the database", e);
        }
        return owner;
    }

private Owner mapRowToOwner(SqlRowSet rowSet) {
    Owner owner = new Owner();
    owner.setId(rowSet.getInt("owner_id"));
    owner.setFirstName(rowSet.getString("first_name"));
    owner.setLastName(rowSet.getString("last_name"));
    owner.setBirthdate(rowSet.getDate("birthdate").toLocalDate());
    owner.setEmail(rowSet.getString("email"));

    return owner;
}
}

