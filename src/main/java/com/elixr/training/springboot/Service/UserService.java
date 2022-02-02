package com.elixr.training.springboot.Service;

import com.elixr.training.springboot.Model.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(String id);

    User updateUser(User user, String id);

    void deleteUser(String id);
}
