package com.shoppingapp.revature.controller;

import com.shoppingapp.revature.exception.CartEmptyException;
import com.shoppingapp.revature.exception.RestExceptionHandler;
import com.shoppingapp.revature.exception.UserLoginFailedException;
import com.shoppingapp.revature.model.User;
import com.shoppingapp.revature.model.UserIdentity;
import com.shoppingapp.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestExceptionHandler exceptionHandler;

    @PostMapping("login")
    public ResponseEntity<Object> getUser(@RequestBody UserIdentity userId) {
        try {
            return ResponseEntity.ok(userService.loginUser(userId));
        }
        catch (UserLoginFailedException e){
            return exceptionHandler.handleLoginException(e);

        }

    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
