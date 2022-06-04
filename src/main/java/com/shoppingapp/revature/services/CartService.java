package com.shoppingapp.revature.services;

import com.shoppingapp.revature.model.Cart;
import com.shoppingapp.revature.model.Item;
import java.util.*;

public interface CartService {
    void addItemToCart(int cartId, int itemId);

    List<Item> getAllItems(int userId);

    void addCart(Cart cart);
}
