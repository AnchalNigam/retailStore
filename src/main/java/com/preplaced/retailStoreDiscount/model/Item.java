package com.preplaced.retailStoreDiscount.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;

import com.preplaced.retailStoreDiscount.utils.Constants.ITEM_TYPE;
import lombok.Data;

import java.util.Set;
import java.util.HashSet;
@Entity
public class Item {
        @Id
        @GeneratedValue
        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        @Enumerated(EnumType.STRING)
        private ITEM_TYPE itemType;

        @ManyToMany(mappedBy = "items")

        private Set<Cart> carts = new HashSet<>();
        public Item() {

        }
        public Item(Long id, String name, String description, BigDecimal price, ITEM_TYPE itemType) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.itemType = itemType;

        }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ITEM_TYPE getItemType() {
            return itemType;
    }
    public Set<Cart> getCarts() {
            return carts;
        }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public Long getId() {
            return id;
        }

}
