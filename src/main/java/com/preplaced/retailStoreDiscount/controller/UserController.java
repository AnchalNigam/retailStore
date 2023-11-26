package com.preplaced.retailStoreDiscount.controller;

import com.preplaced.retailStoreDiscount.Service.UserService;
import com.preplaced.retailStoreDiscount.pojo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.preplaced.retailStoreDiscount.model.User;
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(method= RequestMethod.POST, value="/create")
    public ApiResponse createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value="/{id}")
    public ApiResponse createUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
