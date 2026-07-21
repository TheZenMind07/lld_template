package com.example.repository;

import com.example.domain.User;

import java.util.Map;

public class UserDao {
    private static  int userId = 1;
    Map<Integer, User> store;

    public User addUser(String name, String email) {
        User newUser = User.builder()
                            .name(name)
                            .email(email)
                            .userId(userId++)
                            .build();
        store.put(newUser.getUserId(), newUser);
        return newUser;
    }

}
