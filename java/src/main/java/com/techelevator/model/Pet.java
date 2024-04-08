package com.techelevator.model;

public class Pet {
    private int id;
    private String name;
    private int age;
    private String breed;
    private String size;
    private Boolean isFriendly;
    private int ownerId;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setFriendly(Boolean friendly) {
        isFriendly = friendly;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Pet(int id, String name, int age, String breed, String size, Boolean isFriendly, int ownerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.size = size;
        this.isFriendly = isFriendly;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getSize() {
        return size;
    }

    public Boolean getFriendly() {
        return isFriendly;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public Pet() {

    }
}


