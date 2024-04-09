package com.techelevator.model;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PlayDate {
    @NotNull
    private int playDateId;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private int hostId;
//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @NotNull
    @Future
    private LocalDateTime dateTime;
    @NotNull
    private String location;
    @NotNull
    private boolean publicDate;

    public PlayDate() {}

    public PlayDate(int playDateId, String title, String description, int hostId, LocalDateTime dateTime, String location, boolean publicDate) {
        this.playDateId = playDateId;
        this.title = title;
        this.description = description;
        this.hostId = hostId;
        this.dateTime = dateTime;
        this.location = location;
        this.publicDate = publicDate;
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

    public boolean isPublicDate() {
        return publicDate;
    }

    public void setPublicDate(boolean isPublic) {
        this.publicDate = isPublic;
    }

    public void setPlayDateId(int playDateId) {
        this.playDateId = playDateId;
    }
}
