package com.preplaced.retailStoreDiscount.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    @JoinTable(name = "cart_items",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    @JsonIgnoreProperties(value = "carts")
    private Set<Item> items = new HashSet<>();
    private BigDecimal totalBill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User createdBy;
    public Cart() {

    }

    public void setUserId(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        for (Item item: this.items
             ) {
            totalPrice = new BigDecimal(String.valueOf(item.getPrice())).add(totalPrice);
        }
        this.totalBill = totalPrice;
    }

    public void addItem(Item item) {
        this.items.add(item);
        setPrice();
        item.getCarts().add(this);
    }
//    @JsonIgnore
//    public Set<Item> getItems() {
//        return items;
//    }

    public BigDecimal getTotalBill() {
        return totalBill;
    }

    public int getId() {
        return id;
    }

    public Set<Item> getItems() {
        return this.items;
    }


}
