package com.techelevator.model;

import java.time.LocalDateTime;

public class Message {
    private int messageId;
    private String messageTitle;
    private String messageContent;


    private LocalDateTime messageDateTime;
    private int posterId;
    public  Message() {}
    public Message(int messageId, String messageTitle, String messageContent, LocalDateTime messageDateTime, int posterId) {
        this.messageId = messageId;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.messageDateTime = messageDateTime;
        this.posterId = posterId;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public LocalDateTime getMessageDateTime() {
        return messageDateTime;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setMessageDateTime(LocalDateTime messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }
}
