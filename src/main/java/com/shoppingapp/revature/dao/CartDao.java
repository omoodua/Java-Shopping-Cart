package com.shoppingapp.revature.dao;

import com.shoppingapp.revature.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
}
