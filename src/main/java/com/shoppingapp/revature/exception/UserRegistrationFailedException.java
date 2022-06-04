package com.shoppingapp.revature.exception;

public class UserRegistrationFailedException extends RuntimeException {
    public UserRegistrationFailedException() {
        super("User registration failed.");
    }
}
