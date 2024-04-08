package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PlayDate {
    private int playDateId;
    private String title;
    private String description;
    private int hostId;
//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime dateTime;
    private String location;
    private boolean isPublic;

    public PlayDate() {}

    public PlayDate(int playDateId, String title, String description, int hostId, LocalDateTime dateTime, String location, boolean isPublic) {
        this.playDateId = playDateId;
        this.title = title;
        this.description = description;
        this.hostId = hostId;
        this.dateTime = dateTime;
        this.location = location;
        this.isPublic = isPublic;
    }

    public int getPlayDateId() {
        return playDateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setPlayDateId(int playDateId) {
        this.playDateId = playDateId;
    }
}
