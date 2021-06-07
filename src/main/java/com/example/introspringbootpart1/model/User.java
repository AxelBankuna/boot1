package com.example.introspringbootpart1.model;

public class User {
    private long id;
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}