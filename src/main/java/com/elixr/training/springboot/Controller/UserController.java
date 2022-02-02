package com.elixr.training.springboot.Controller;

import com.elixr.training.springboot.Constants.Constants;
import com.elixr.training.springboot.ExceptionHandler.ErrorResponse;
import com.elixr.training.springboot.ExceptionHandler.Response;
import com.elixr.training.springboot.Model.User;
import com.elixr.training.springboot.Service.UserService;
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
        return new ResponseEntity<>(new Response(Constants.SUCCESS, userService.createUser(user)), HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<?> getAllUsers() {
        List<User> getuser = userService.getAllUsers();
        return new ResponseEntity<>(new Response(Constants.SUCCESS, getuser), HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String id) {
        return new ResponseEntity<>(new Response(Constants.SUCCESS, userService.getUserById(id)), HttpStatus.OK);
    }

    @PatchMapping("users/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") String id, @Valid @RequestBody User user) {
        return new ResponseEntity<>(new Response(Constants.SUCCESS, userService.updateUser(user, id)), HttpStatus.OK);
    }

    @DeleteMapping("users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(new ErrorResponse(Constants.SUCCESS, Constants.DELETE_USER), HttpStatus.OK);
    }
}