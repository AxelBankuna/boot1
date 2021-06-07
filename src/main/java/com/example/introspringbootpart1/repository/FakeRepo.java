package com.example.introspringbootpart1.repository;

import com.example.introspringbootpart1.model.User;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Repository("user-repository")
public class FakeRepo implements FakeRepoInterface {
    private long generatedId = 0;
    private Map<Long, User> users = new HashMap<>();

    public String insertUser(String name, String surname) {
        User newUser = new User(name, surname);
        users.put(++generatedId, newUser);

        try {
            Field id = User.class.getDeclaredField("id");
            id.setAccessible(true);
            id.set(newUser, generatedId);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }

        return users.get(generatedId).getName();
    }

    public String findUserById(long id) {
        User user = users.get(id);

        if (user == null)
            return null;

        return user.getName();
    }

    public String deleteUser(long id) {
        User user = users.remove(id);

        if (user == null)
            return null;

        return user.getName();
    }
}
