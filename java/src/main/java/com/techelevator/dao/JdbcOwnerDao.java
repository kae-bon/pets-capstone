package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.exception.UnderEighteenException;
import com.techelevator.model.Owner;
import com.techelevator.model.RegisterOwnerDto;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
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

    private final String SELECT_SQL = "SELECT user_id, first_name, last_name, birthdate FROM owners ";


    @Override
    public Owner createOwner(RegisterOwnerDto owner) {
        Owner newOwner = null;
        String sql = "INSERT INTO owners(user_id, first_name, last_name, birthdate) values(?,?, ?, ?) RETURNING user_id;";
        try {
            int newOwnerId = jdbcTemplate.queryForObject(
                    sql,
                    int.class,
                    owner.getId(),
                    owner.getFirstName(),
                    owner.getLastName(),
                    owner.getBirthdate()
            );
            newOwner = getOwnerById(newOwnerId);
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        } catch (DataIntegrityViolationException e) {
            throw new UnderEighteenException("Must be eighteen or older", e);
        }
        catch (DataAccessException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newOwner;
    }

    @Override
    public Owner getOwnerByEmail(String email) {
        Owner owner = null;
        return owner;
    }
    @Override
    public Owner getOwnerById(int ownerId) {
        Owner owner = null;
        String sql = SELECT_SQL + "WHERE user_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, ownerId);
            while (rowSet.next()) {
                owner = mapRowToOwner(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return owner;
    }

private Owner mapRowToOwner(SqlRowSet rowSet) {
    Owner owner = new Owner();
    owner.setId(rowSet.getInt("user_id"));
    owner.setFirstName(rowSet.getString("first_name"));
    owner.setLastName(rowSet.getString("last_name"));
    owner.setBirthdate(rowSet.getDate("birthdate").toLocalDate());

    return owner;
}
}

