package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(String id);

    User updateUser(User user, String id);

    void deleteUser(String id);
}