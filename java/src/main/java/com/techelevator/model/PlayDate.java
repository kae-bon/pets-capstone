package com.techelevator.model;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private int locationId;
    @NotNull
    private boolean publicDate;

    private List<Pet> attendingPets;

    public PlayDate() {}

    public PlayDate(int playDateId, String title, String description, int hostId, LocalDateTime dateTime, int locationId, boolean publicDate) {
        this.playDateId = playDateId;
        this.title = title;
        this.description = description;
        this.hostId = hostId;
        this.dateTime = dateTime;
        this.locationId = locationId;
        this.publicDate = publicDate;
        this.attendingPets = new ArrayList<>();
    }

    public PlayDate(List<Pet> attendingPets, int playDateId, String title, String description, int hostId, LocalDateTime dateTime, int locationId, boolean publicDate) {
        this (playDateId,  title, description, hostId,  dateTime, locationId, publicDate);
        this.attendingPets = attendingPets;
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

    public int getLocationId() {
        return locationId;
    }

    public List<Pet> getAttendingPets() {
        return attendingPets;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public void setAttendingPets(List<Pet> pets) {
        this.attendingPets = pets;
    }
}
