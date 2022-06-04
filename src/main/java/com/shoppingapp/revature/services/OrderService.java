package com.shoppingapp.revature.services;

import com.shoppingapp.revature.model.Order;

public interface OrderService {
    void addOrder(Order order);
    Order getOrder(int orderId);
}
