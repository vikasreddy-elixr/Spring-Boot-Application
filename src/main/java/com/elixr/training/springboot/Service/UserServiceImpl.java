package com.elixr.training.springboot.Service;

import com.elixr.training.springboot.Constants.Constants;
import com.elixr.training.springboot.Dao.UserRepository;
import com.elixr.training.springboot.ExceptionHandler.ResourceNotFoundException;
import com.elixr.training.springboot.Model.User;
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
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Constants.USER_NOT_FOUND + id));
    }

    @Override
    public User updateUser(User user, String id) {
        User existingUser = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Constants.USER_NOT_FOUND + id));
        existingUser.setUserName(user.getUserName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        userRepo.save(existingUser);
        return existingUser;

    }

    @Override
    public void deleteUser(String id) {
        userRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Constants.USER_NOT_FOUND + id));
        userRepo.deleteById(id);
    }
}

