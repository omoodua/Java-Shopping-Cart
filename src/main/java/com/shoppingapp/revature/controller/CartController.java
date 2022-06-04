package com.shoppingapp.revature.controller;

import com.shoppingapp.revature.exception.CartEmptyException;
import com.shoppingapp.revature.exception.RestExceptionHandler;
import com.shoppingapp.revature.model.Cart;
import com.shoppingapp.revature.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;


    @Autowired
    private RestExceptionHandler restExceptionHandler;

    @PostMapping
    public ResponseEntity<String> createCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
        return ResponseEntity.ok("Cart created successfully.");
    }

    @GetMapping("{cartId}/items")
    public ResponseEntity<Object> getCartItems(@PathVariable int cartId) {
        try {
            return ResponseEntity.ok(cartService.getAllItems(cartId));
        }
        catch (CartEmptyException e){
            return restExceptionHandler.handleEmptyCartException(e);

        }
    }

    @GetMapping("{cartId}/items/{itemId}")
    public ResponseEntity<String> addItemToCart(@PathVariable int cartId, @PathVariable int itemId) {
        cartService.addItemToCart(cartId, itemId);
        return ResponseEntity.ok("Item successfully added to cart.");
    }
}
