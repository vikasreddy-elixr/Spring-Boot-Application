package com.elixr.springbootapplication.service;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.repository.UserRepository;
import com.elixr.springbootapplication.model.User;
import com.elixr.springbootapplication.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user,String userName) {
        if(userRepo.existsUserByUserName(userName)) {
            return userRepo.insert(user);
        } else{
            throw new NotFoundException(Constants.DUPLICATE_KEY);
        }
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
    public User updateUser(User user, String id,String userName) {
        if(userRepo.existsUserByUserName(userName)) {
            User existingUser = userRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.ERROR_NOT_FOUND));
            existingUser.setUserName(user.getUserName());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            userRepo.save(existingUser);
            return existingUser;
        }
        else{
            throw new NotFoundException(Constants.DUPLICATE_KEY);
        }
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


