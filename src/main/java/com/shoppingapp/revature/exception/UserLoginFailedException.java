package com.shoppingapp.revature.exception;

public class UserLoginFailedException extends RuntimeException {
    public UserLoginFailedException() {
        super("Login Failed.");
    }
}
