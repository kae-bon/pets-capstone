package com.techelevator.controller;

import com.techelevator.dao.MessageDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Message> getMessages() {
        try {
            return messageDao.getMessages();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot connect to database - try again later!");
        }
    }
}
