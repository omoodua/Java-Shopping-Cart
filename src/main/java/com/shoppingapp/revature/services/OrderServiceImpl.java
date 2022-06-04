package com.shoppingapp.revature.services;

import com.shoppingapp.revature.dao.OrderDao;
import com.shoppingapp.revature.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {
        orderDao.save(order);
    }

    @Override
    public Order getOrder(int orderId) {
        return orderDao.findById(orderId).orElse( null);
    }
}
