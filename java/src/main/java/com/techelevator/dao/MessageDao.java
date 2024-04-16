package com.techelevator.dao;

import com.techelevator.model.Message;
import com.techelevator.model.MessageDTO;

import java.util.List;

public interface MessageDao {
    public List<MessageDTO> getMessages();

    public Message getMessageById (int messageId);
    public Message createMessage(Message message);
}
