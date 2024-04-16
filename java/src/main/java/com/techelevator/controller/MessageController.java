package com.techelevator.controller;

import com.techelevator.dao.MessageDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Message;
import com.techelevator.model.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/messages")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class MessageController {
    private final MessageDao messageDao;

    public MessageController(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @GetMapping
    public List<MessageDTO> getMessages() {
        try {
            return messageDao.getMessages();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to database - try again later!");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message createMessage(@RequestBody Message newMessage) {
        try {
            return messageDao.createMessage(newMessage);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to database - try again later!");
        }
    }
}
