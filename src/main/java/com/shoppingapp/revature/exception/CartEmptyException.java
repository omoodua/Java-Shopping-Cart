package com.shoppingapp.revature.exception;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException() {
        super("Cart Empty");
    }
}
