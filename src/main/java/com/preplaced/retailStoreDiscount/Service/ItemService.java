package com.preplaced.retailStoreDiscount.Service;

import com.preplaced.retailStoreDiscount.model.User;
import com.preplaced.retailStoreDiscount.pojo.ApiResponse;
import com.preplaced.retailStoreDiscount.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.preplaced.retailStoreDiscount.model.Item;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    public ApiResponse createItem(Item item) {
        System.out.println(item.getId() + " " + item.getName());
        itemRepository.save(item);
        return new ApiResponse(HttpStatus.CREATED, "Items created successfully!", null);
    }

    public ApiResponse getItemById(int id) {
        System.out.println("User" + id);
        Item user = itemRepository.findById(id);
        System.out.println(user);
        return new ApiResponse(HttpStatus.CREATED, "Item get Successfully!", user);
    }


}
