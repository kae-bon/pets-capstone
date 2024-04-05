package com.techelevator.model;

public class Pet {
    private int id;
    private String name;
    private int age;
    private String breed;
    private String size;
    private Boolean isFriendly;
    private int ownerId;

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


