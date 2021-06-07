package com.example.introspringbootpart1.service;

import com.example.introspringbootpart1.model.User;
import com.example.introspringbootpart1.repository.FakeRepo;
import com.example.introspringbootpart1.repository.FakeRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;

@Service
public class UserServiceImpl implements UserService{
    private FakeRepoInterface userRepository;

    public UserServiceImpl(FakeRepoInterface userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(String name, String surname) {
        return userRepository.insertUser(name, surname);
    }

    public String getUser(long id) {
        return userRepository.findUserById(id);
    }

    public String removeUser(long id) {
        return userRepository.deleteUser(id);
    }
}
