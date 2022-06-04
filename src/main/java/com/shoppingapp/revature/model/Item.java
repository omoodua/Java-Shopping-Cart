package com.shoppingapp.revature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    @OneToMany(mappedBy = "item")
    private List<Order> orders;
    @ManyToMany
    @JoinTable(name="cart_items",
            joinColumns = {@JoinColumn(name="item_id")},
    inverseJoinColumns = {@JoinColumn(name="cart_id")})
    private List<Cart> carts;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
