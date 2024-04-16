package com.techelevator.model;

import java.time.LocalDateTime;

public class Message {
    private int messageId;
    private String messageTitle;
    private String messageContent;
    private LocalDateTime dateTimePosted;
    private int posterId;

    public Message() {}

    public Message(int messageId, String messageTitle, String messageContent, LocalDateTime dateTimePosted, int posterId) {
        this.messageId = messageId;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.dateTimePosted = dateTimePosted;
        this.posterId = posterId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalDateTime getDateTimePosted() {
        return dateTimePosted;
    }

    public void setDateTimePosted(LocalDateTime dateTimePosted) {
        this.dateTimePosted = dateTimePosted;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }
}
