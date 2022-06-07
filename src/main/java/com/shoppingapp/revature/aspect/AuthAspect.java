package com.shoppingapp.revature.aspect;

import com.shoppingapp.revature.dao.UserDao;
import com.shoppingapp.revature.exception.UserLoginFailedException;
import com.shoppingapp.revature.model.User;
import com.shoppingapp.revature.model.UserIdentity;
import com.shoppingapp.revature.services.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {



    @Autowired
    private UserService userService;

    // Aspect - the basic unit of modularity in aspect-oriented programming
    // Joinpoint - An entry point into the program - method
    // Pointcut - An expression that defines the joinpoints we are going to target.
    // Advice - an action that can be taken within an aspect.
    // 1. Before - action taken before a method is executed.
    // 2. After - action taken after a method terminates normally or by throwing an exception.
    // 3. After throwing - action taken after a method terminates by throwing an exception.
    // 4. Around - action taken before and after a method is executed

    // access_modifier return_type  method_name(argument_types)
    // public ResponseEntity<String> com.shoppingapp.revature.controller.UserController.getUser(UserIdentity)
    @Pointcut("execution(public * com.shoppingapp.revature.controller.UserController.getUser(..))")
    public void login() {

    }

    @Around("login()")
    public void authenticate(ProceedingJoinPoint joinPoint) {
        UserIdentity userId = (UserIdentity) joinPoint.getArgs()[0];
        try {
            User user = userService.loginUser(userId);
            if(user == null){
                throw new UserLoginFailedException();
            }
            joinPoint.proceed(new Object[]{userId});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
