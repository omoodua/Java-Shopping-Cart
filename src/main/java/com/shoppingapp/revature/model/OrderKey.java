package com.shoppingapp.revature.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


public class OrderKey implements Serializable {

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "user_id")
    private int userId;

    public OrderKey() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderKey)) return false;
        OrderKey orderKey = (OrderKey) o;
        return itemId == orderKey.itemId && userId == orderKey.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, userId);
    }

}

