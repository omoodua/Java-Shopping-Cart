package com.shoppingapp.revature.services;

import com.shoppingapp.revature.dao.UserDao;
import com.shoppingapp.revature.exception.UserLoginFailedException;
import com.shoppingapp.revature.model.User;
import com.shoppingapp.revature.model.UserIdentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user) {
        userDao.save(user);
    }

    @Override
    public User loginUser(UserIdentity userId) {
        User user = userDao.findByEmailAndPassword(userId.getEmail(), userId.getPassword()).orElse(null);
        if(user == null){
            throw new UserLoginFailedException();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
