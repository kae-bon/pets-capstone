package com.techelevator.model;

import java.time.LocalDateTime;

public class Message {
    private int messageId;
    private String messageTitle;
    private String messageContent;
    private LocalDateTime dateTimePosted;
    private String posterFirstName;
    private String posterLastName;


    public Message() {}

    public Message(int messageId, String messageTitle, String messageContent, LocalDateTime dateTimePosted, String posterFirstName, String posterLastName) {
        this.messageId = messageId;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.dateTimePosted = dateTimePosted;
        this.posterFirstName = posterFirstName;
        this.posterLastName = posterLastName;

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

    public String getPosterFirstName() {
        return posterFirstName;
    }

    public void setPosterFirstName(String posterFirstName) {
        this.posterFirstName = posterFirstName;
    }

    public String getPosterLastName() {
        return posterLastName;
    }

    public void setPosterLastName(String posterLastName) {
        this.posterLastName = posterLastName;
    }
}
