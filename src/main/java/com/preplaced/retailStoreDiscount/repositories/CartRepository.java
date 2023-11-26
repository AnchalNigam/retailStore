package com.preplaced.retailStoreDiscount.repositories;

import com.preplaced.retailStoreDiscount.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import com.preplaced.retailStoreDiscount.model.Cart;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT \n" +
            "    c1_0.id,\n" +
            "    c1_0.user_id,\n" +
            "    c2_0.name as userName,\n" +
            "    c2_0.user_type,\n" +
            "    cartItem.cart_id,\n" +
            "    c1_0.total_bill,\n" +
            "    i1_1.description,\n" +
            "    i1_1.item_type,\n" +
            "    i1_1.name as itemName,\n" +
            "    i1_1.price\n" +
            "FROM\n" +
            "    cart c1_0\n" +
            "        JOIN\n" +
            "    user c2_0 ON c2_0.id = c1_0.user_id\n" +
            "        LEFT JOIN\n" +
            "    (cart_items cartItem\n" +
            "    JOIN item i1_1 ON i1_1.id = cartItem.item_id) ON c1_0.id = cartItem.cart_id\n" +
            "WHERE\n" +
            "    c1_0.id = :id", nativeQuery = true)
    Cart findInfo(int id);

    Cart findById(int id);
}
