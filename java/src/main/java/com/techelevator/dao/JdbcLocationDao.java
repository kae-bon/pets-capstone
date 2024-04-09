package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Location;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLocationDao implements LocationDao {
    private final JdbcTemplate jdbc;
    public JdbcLocationDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT location_id, location_name, street_address, city, state_abbr\n" +
                "FROM locations;";

        try {
            SqlRowSet results = jdbc.queryForRowSet(sql);
            while (results.next()) {
                locations.add(mapRowToLocation(results));
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return locations;
    }

    private Location mapRowToLocation(SqlRowSet results) {
        Location location = new Location(results.getInt("location_id"),
                results.getString("location_name"),
                results.getString("street_address"),
                results.getString("city"),
                results.getString("state_abbr"));
        return location;
    }
}
