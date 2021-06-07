package com.example.introspringbootpart1.repository;

public interface FakeRepoInterface {
    String insertUser(String name, String surname);
    String findUserById(long id);
    String deleteUser(long id);
}
