package com.shoppingapp.revature.controller;

import com.shoppingapp.revature.dao.ItemDao;
import com.shoppingapp.revature.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        itemDao.save(item);
        return ResponseEntity.ok("Item successfully added.");
    }
}
