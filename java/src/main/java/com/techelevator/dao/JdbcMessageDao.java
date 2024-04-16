package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Message;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcMessageDao implements MessageDao {
    private final JdbcTemplate jdbc;
    public JdbcMessageDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT message_id, message_title, message_content, date_time, poster_id\n" +
                "FROM messages;";
        try {
            SqlRowSet results = this.jdbc.queryForRowSet(sql);
            while (results.next()) {
                Message message = mapRowToMessage(results);
                messages.add(message);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }

        return messages;
    }

    private Message mapRowToMessage(SqlRowSet result) {
        return new Message(result.getInt("message_id"),
                            result.getString("message_title"),
                            result.getString("message_content"),
                            result.getTimestamp("date_time").toLocalDateTime(),
                            result.getInt("poster_id"));
    }
}
