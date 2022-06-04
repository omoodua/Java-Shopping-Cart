package com.shoppingapp.revature.services;

import com.shoppingapp.revature.dao.ItemDao;
import com.shoppingapp.revature.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getAllItems() {
        return itemDao.findAll();
    }
}
