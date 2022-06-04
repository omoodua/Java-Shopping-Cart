package com.shoppingapp.revature.services;

import com.shoppingapp.revature.dao.CartDao;
import com.shoppingapp.revature.dao.ItemDao;
import com.shoppingapp.revature.exception.CartEmptyException;
import com.shoppingapp.revature.model.Cart;
import com.shoppingapp.revature.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ItemDao itemDao;


    @Override
    public void addItemToCart(int cartId, int itemId) {
        Cart cart = cartDao.findById(cartId).orElse(null);
        if(cart == null) {
            throw new RuntimeException("Could not find cart with ID " + cartId);
        }

        Item item = itemDao.findById(itemId).orElse(null);
        if(item == null) {
            throw new RuntimeException("Could not find item with ID " + itemId);
        }

        item.getCarts().add(cart);
        cart.getItems().add(item);

        itemDao.save(item);
        cartDao.save(cart);
    }



    @Override
    public List<Item> getAllItems(int id) {
        Cart cart = cartDao.findById(id).orElse(null);
        if(cart == null) {
            throw new RuntimeException("Cart with ID " + id + " not found.");
        }
        if(cart.getItems().isEmpty()){
            throw new CartEmptyException();
        }
        return cart.getItems();
    }

    @Override
    public void addCart(Cart cart) {
        cartDao.save(cart);
    }
}
