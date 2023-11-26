package com.preplaced.retailStoreDiscount.controller;

import com.preplaced.retailStoreDiscount.Service.ItemService;
import com.preplaced.retailStoreDiscount.pojo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.preplaced.retailStoreDiscount.model.Item;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ApiResponse createItem(@RequestBody Item item) {
//        return item;
       return itemService.createItem(item);
    }

    @RequestMapping(value="/{id}")
    public ApiResponse createUser(@PathVariable int id) {
        return itemService.getItemById(id);
    }
}
