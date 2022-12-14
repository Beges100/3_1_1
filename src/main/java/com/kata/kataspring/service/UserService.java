package com.kata.kataspring.service;


import com.kata.kataspring.model.User;

import java.util.List;

public interface UserService {

    void updateUser(int id, User user);

    User getUserAtId(int id);

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();
}