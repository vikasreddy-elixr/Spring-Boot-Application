package com.elixr.springbootapplication.controller;

import com.elixr.springbootapplication.model.User;
import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.responses.SuccessResponse;
import com.elixr.springbootapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, userService.createUser(user)), HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<?> getAllUsers() {
        List<User> getuser = userService.getAllUsers();
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, getuser), HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String id) {
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, userService.getUserById(id)), HttpStatus.OK);
    }

    @PatchMapping("users/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") String id, @Valid @RequestBody User user) {
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, userService.updateUser(user, id)), HttpStatus.OK);
    }

    @DeleteMapping("users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(new SuccessResponse(Constants.SUCCESS, id), HttpStatus.OK);
    }
}

