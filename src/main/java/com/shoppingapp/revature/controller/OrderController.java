package com.shoppingapp.revature.controller;

import com.shoppingapp.revature.dao.OrderDao;
import com.shoppingapp.revature.model.Order;
import com.shoppingapp.revature.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.ok("Order added successfully.");
    }

    @GetMapping("{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable int orderId) {
        Order order = orderService.getOrder(orderId);
        return order == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(order);
    }
}
