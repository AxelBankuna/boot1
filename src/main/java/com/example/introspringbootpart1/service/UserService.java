package com.example.introspringbootpart1.service;

import com.example.introspringbootpart1.model.User;

import java.lang.reflect.Field;

public interface UserService {
    String addUser(String name, String surname);

    String getUser(long id);

    String removeUser(long id);
}
