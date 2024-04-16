package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.PlayDate;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlayDateDao implements PlayDateDao{
    private final JdbcTemplate jdbc;
    public JdbcPlayDateDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public PlayDate getPlayDateById(int playDateId) {
        PlayDate playDate = null;
        String sql = "SELECT play_date_id, title, description, host_id, date_time, end_date_time, location_id, ispublic\n" +
                "\tFROM play_dates\n" +
                "\tWHERE play_date_id = ?;";
        try {
            SqlRowSet results = jdbc.queryForRowSet(sql, playDateId);
            if (results.next()) {
                playDate = mapRowToPlayDate(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server.", e);
        }
        return playDate;
    }

    @Override
    public PlayDate createPlayDate(PlayDate newPlayDate) {
        PlayDate playDate = null;
        String sql = "INSERT INTO play_dates(\n" +
                "\ttitle, description, host_id, date_time, end_date_time, location_id, ispublic)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?) RETURNING play_date_id;";
        try {
            int playDateId = jdbc.queryForObject(sql, int.class,
                    newPlayDate.getTitle(),
                    newPlayDate.getDescription(),
                    newPlayDate.getHostId(),
                    newPlayDate.getDateTime(),
                    newPlayDate.getEndDateTime(),
                    newPlayDate.getLocationId(),
                    newPlayDate.isPublicDate());
            playDate = getPlayDateById(playDateId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation.", e);
        }
        return playDate;
    }



    @Override
    public List<PlayDate> getUpcomingPlayDates() {
        List<PlayDate> publicPlayDates = new ArrayList<>();
        String sql = "SELECT play_date_id, title, description, host_id, date_time, end_date_time, location_id, ispublic\n" +
                "FROM play_dates\n" +
                "WHERE ispublic AND date_time > CURRENT_TIMESTAMP\n" +
                "ORDER BY date_time ASC;";
        try {
            SqlRowSet results = this.jdbc.queryForRowSet(sql);
            while (results.next()) {
                PlayDate playDate = mapRowToPlayDate(results);
                publicPlayDates.add(playDate);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }

        return publicPlayDates;
    }

    @Override
    public List<PlayDate> getUserPlayDates(int userId, String timeOfDay) {
        List<PlayDate> userPlayDates = new ArrayList<>();
        String sql = "SELECT play_date_id, title, description, host_id, date_time, end_date_time, location_id, ispublic\n" +
                "FROM play_dates\n" +
                "WHERE host_id = ? AND date_time > CURRENT_TIMESTAMP\n" +
                "ORDER BY date_time ASC;";

        try {
            SqlRowSet results = this.jdbc.queryForRowSet(sql, userId);
            while (results.next()) {
                PlayDate playDate = mapRowToPlayDate(results);
                userPlayDates.add(playDate);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }

        return userPlayDates;
    }

    private PlayDate mapRowToPlayDate(SqlRowSet results) {
        PlayDate playDate = new PlayDate();
        playDate.setPlayDateId(results.getInt("play_date_id"));
        playDate.setDescription(results.getString("description"));
        playDate.setHostId(results.getInt("host_id"));
        playDate.setLocationId(results.getInt("location_id"));
        playDate.setTitle(results.getString("title"));
        playDate.setPublicDate(results.getBoolean("ispublic"));
        playDate.setDateTime(results.getTimestamp("date_time").toLocalDateTime());
        playDate.setEndDateTime(results.getTimestamp("end_date_time").toLocalDateTime());

        return playDate;
    }
}
