package com.example.introspringbootpart1.service;

import com.example.introspringbootpart1.repository.FakeRepo;
import com.example.introspringbootpart1.repository.FakeRepoInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplIntegrationTest {
    @Autowired private FakeRepoInterface fakeRepo;

    @Autowired private UserService userService;

    @Test
    public void addUser_test(){
        String username = userService.addUser("name", "surname");
        assertEquals("name", username);
    }

    @Test
    public void removeUser_test(){
        fakeRepo.insertUser("name", "surname");
        String username = userService.removeUser(1);
        assertEquals("name", username);
    }

    @Test
    public void getUser_test(){
        fakeRepo.insertUser("name", "surname");
        String username = userService.getUser(1);
        assertEquals("name", username);
    }
}