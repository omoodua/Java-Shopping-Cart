package com.shoppingapp.revature.services;

import com.shoppingapp.revature.model.User;
import com.shoppingapp.revature.model.UserIdentity;

import java.util.List;
import java.util.Optional;

    public interface  UserService {
        void registerUser(User user);
        User loginUser(UserIdentity userId);
        List<User> getAllUsers();
    }

