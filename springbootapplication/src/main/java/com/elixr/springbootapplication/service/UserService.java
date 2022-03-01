package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user,String userName);

    List<User> getAllUsers();

    User getUserById(String id);

    User updateUser(User user, String id,String userName);

    void deleteUser(String id);
}

