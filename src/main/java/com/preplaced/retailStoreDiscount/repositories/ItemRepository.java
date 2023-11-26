package com.preplaced.retailStoreDiscount.repositories;

import com.preplaced.retailStoreDiscount.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.preplaced.retailStoreDiscount.model.Item;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findById(int id);

    List<Item> findAllByIdIn(List<Long> ids);
}
