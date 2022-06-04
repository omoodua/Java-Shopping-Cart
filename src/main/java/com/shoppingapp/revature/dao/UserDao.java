package com.shoppingapp.revature.dao;

import com.shoppingapp.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
