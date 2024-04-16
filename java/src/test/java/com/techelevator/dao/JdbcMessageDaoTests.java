package com.techelevator.dao;

import com.techelevator.model.Message;
import com.techelevator.model.MessageDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class JdbcMessageDaoTests extends BaseDaoTests {
    private JdbcMessageDao sut;
    private final MessageDTO MESSAGE_ONE = new MessageDTO(1, "Best Park", "What is the best park for small dogs?", LocalDateTime.of(2024, 5, 2, 10, 30, 0), "Kae", "Bonaguro");
    private final MessageDTO MESSAGE_TWO = new MessageDTO(2, "Join us for a birthday party", "Throwing a birthday party for my dog Murphy - everyone is invited!", LocalDateTime.of(2024, 7, 1, 11, 30, 0), "Steve", "McQueen");
    private final Message MESSAGE_THREE = new Message(1, "Best Park", "What is the best park for small dogs?",LocalDateTime.of(2024, 5, 2, 10, 30, 0), 2);
    private final Message MESSAGE_FOUR = new Message(2, "Join us for a birthday party", "Throwing a birthday party for my dog Murphy - everyone is invited!", LocalDateTime.of(2024, 7, 1, 11, 30, 0), 1);
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcMessageDao(jdbcTemplate);
    }

    @Test
    public void getAllMessages() {
        List<MessageDTO> messages = sut.getMessages();

        Assert.assertNotNull(messages);
        assertMessageDTOsMatch(MESSAGE_ONE, messages.get(1));
        assertMessageDTOsMatch(MESSAGE_TWO, messages.get(0));
    }

    @Test
    public void getMessageByID() {
        Message message = sut.getMessageById(1);
        assertMessagesMatch(MESSAGE_THREE, message);
        message = sut.getMessageById(2);
        assertMessagesMatch(MESSAGE_FOUR, message);
    }

    @Test
    public void createMessage() {
        Message newMessage = new Message(0, "Test", "Test", LocalDateTime.of(2024, 4, 25, 14, 00, 00), 2);

        Message createdMessage = sut.createMessage(newMessage);
        int newId = createdMessage.getMessageId();
        Assert.assertTrue(newId > 0);

        Message retrievedMessage = sut.getMessageById(newId);
        assertMessagesMatch(createdMessage, retrievedMessage);
    }


    private void assertMessageDTOsMatch(MessageDTO expected, MessageDTO actual) {
        Assert.assertEquals(expected.getMessageId(), actual.getMessageId());
        Assert.assertEquals(expected.getMessageTitle(), actual.getMessageTitle());
        Assert.assertEquals(expected.getMessageContent(), actual.getMessageContent());
        Assert.assertEquals(expected.getDateTimePosted(), actual.getDateTimePosted());
        Assert.assertEquals(expected.getPosterFirstName(), actual.getPosterFirstName());
        Assert.assertEquals(expected.getPosterLastName(), actual.getPosterLastName());
    }

    private void assertMessagesMatch(Message expected, Message actual) {
        Assert.assertEquals(expected.getMessageId(), actual.getMessageId());
        Assert.assertEquals(expected.getMessageTitle(), actual.getMessageTitle());
        Assert.assertEquals(expected.getMessageContent(), actual.getMessageContent());
        Assert.assertEquals(expected.getMessageDateTime(), actual.getMessageDateTime());
        Assert.assertEquals(expected.getPosterId(), actual.getPosterId());
    }
}
