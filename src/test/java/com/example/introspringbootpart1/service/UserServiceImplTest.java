package com.example.introspringbootpart1.service;

import com.example.introspringbootpart1.repository.FakeRepoInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private FakeRepoInterface fakeRepo = Mockito.mock(FakeRepoInterface.class);

    private UserService userService = new UserServiceImpl(fakeRepo);

    @Test
    public void addUser_test(){
        Mockito.when(fakeRepo.insertUser("name", "surname")).thenReturn("name");
        String username = userService.addUser("name", "surname");
        assertEquals("name", username);
    }

    @Test
    public void removeUser_test(){
        Mockito.when(fakeRepo.deleteUser(1)).thenReturn("name");
        String username = userService.removeUser(1);
        assertEquals("name", username);
    }

    @Test
    public void getUser_test(){
        Mockito.when(fakeRepo.findUserById(1)).thenReturn("name");
        String username = userService.getUser(1);
        assertEquals("name", username);
    }
}