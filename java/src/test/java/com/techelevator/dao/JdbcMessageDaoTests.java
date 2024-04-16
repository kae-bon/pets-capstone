package com.techelevator.dao;

import com.techelevator.model.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class JdbcMessageDaoTests extends BaseDaoTests {
    private JdbcMessageDao sut;
    private final Message MESSAGE_ONE = new Message(1, "Best Park", "What is the best park for small dogs?", LocalDateTime.of(2024, 5, 2, 10, 30, 0), "Kae", "Bonaguro");
    private final Message MESSAGE_TWO = new Message(2, "Join us for a birthday party", "Throwing a birthday party for my dog Murphy - everyone is invited!", LocalDateTime.of(2024, 7, 1, 11, 30, 0), "Steve", "McQueen");
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcMessageDao(jdbcTemplate);
    }

    @Test
    public void getAllMessages() {
        List<Message> messages = sut.getMessages();

        Assert.assertNotNull(messages);
        assertMessagesMatch(MESSAGE_ONE, messages.get(1));
        assertMessagesMatch(MESSAGE_TWO, messages.get(0));
    }


    private void assertMessagesMatch(Message expected, Message actual) {
        Assert.assertEquals(expected.getMessageId(), actual.getMessageId());
        Assert.assertEquals(expected.getMessageTitle(), actual.getMessageTitle());
        Assert.assertEquals(expected.getMessageContent(), actual.getMessageContent());
        Assert.assertEquals(expected.getDateTimePosted(), actual.getDateTimePosted());
        Assert.assertEquals(expected.getPosterFirstName(), actual.getPosterFirstName());
        Assert.assertEquals(expected.getPosterLastName(), actual.getPosterLastName());

    }
}
