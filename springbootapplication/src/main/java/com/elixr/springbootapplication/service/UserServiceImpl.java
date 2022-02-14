package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.repository.UserRepository;
import com.elixr.springbootapplication.model.User;
import com.elixr.springbootapplication.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        return userRepo.insert(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
    }

    @Override
    public User updateUser(User user, String id) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
        existingUser.setUserName(user.getUserName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        userRepo.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(String id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw (new NotFoundException(Constants.ERROR_NOT_FOUND));
        }
    }
}
