package com.shoppingapp.revature.exception;

import com.shoppingapp.revature.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class RestExceptionHandler {
    public ResponseEntity<Object> buildResponseEntity(ApiError apiError){
        return ResponseEntity.badRequest().body(apiError);

    }
    public ResponseEntity<Object> handleRegistrationException(UserRegistrationFailedException userRegistrationFailedException){
        return ResponseEntity.badRequest().body(userRegistrationFailedException.getMessage());
    }
    public ResponseEntity<Object> handleLoginException(UserLoginFailedException userLoginFailedException){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userLoginFailedException.getMessage());
    }
    public ResponseEntity<Object> handleEmptyCartException(CartEmptyException cartEmptyException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cartEmptyException.getMessage());
    }




}
