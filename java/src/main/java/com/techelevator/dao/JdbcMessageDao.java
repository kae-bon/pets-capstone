package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Message;
import com.techelevator.model.MessageDTO;
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
    public List<MessageDTO> getMessages() {
        List<MessageDTO> messages = new ArrayList<>();
        String sql = "SELECT message_id, message_title, message_content, date_time, owners.first_name, owners.last_name\n" +
                "FROM messages\n" +
                "JOIN owners ON owners.user_id = messages.poster_id\n" +
                "ORDER BY date_time DESC;";
        try {
            SqlRowSet results = this.jdbc.queryForRowSet(sql);
            while (results.next()) {
                MessageDTO message = mapRowToMessageDTO(results);
                messages.add(message);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }

        return messages;
    }

    @Override
    public Message getMessageById(int messageId) {
        Message message = new Message();
        String sql = "SELECT message_id, message_title, message_content, date_time, poster_id\n" +
                "FROM messages\n" +
                "WHERE message_id = ?;";
        try {
            SqlRowSet results = jdbc.queryForRowSet(sql, messageId);
            if (results.next()) {
                message = mapRowToMessage(results);
            }

        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }

        return message;
    };
    @Override
    public Message createMessage(Message message) {
        Message newMessage = new Message();
        String sql = "INSERT INTO messages(message_title, message_content, date_time, poster_id)\n" +
                "VALUES ( ?, ?, ?, ?)\n" +
                "RETURNING message_id;";
        try {
           int messageId = jdbc.queryForObject(sql, int.class, message.getMessageTitle(), message.getMessageContent(), message.getMessageDateTime(), message.getPosterId());
           newMessage = getMessageById(messageId);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }

        return newMessage;
    }

    private MessageDTO mapRowToMessageDTO(SqlRowSet result) {
        return new MessageDTO(result.getInt("message_id"),
                            result.getString("message_title"),
                            result.getString("message_content"),
                            result.getTimestamp("date_time").toLocalDateTime(),
                            result.getString("first_name"),
                            result.getString("last_name"));
    }
    private Message mapRowToMessage(SqlRowSet result) {
        return new Message(result.getInt("message_id"),
                result.getString("message_title"),
                result.getString("message_content"),
                result.getTimestamp("date_time").toLocalDateTime(),
                result.getInt("poster_id"));
    }

}
