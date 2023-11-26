package com.preplaced.retailStoreDiscount.controller;

import com.preplaced.retailStoreDiscount.Service.CartService;
import com.preplaced.retailStoreDiscount.pojo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.preplaced.retailStoreDiscount.pojo.CartRequest;
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @RequestMapping(method= RequestMethod.POST, value = "/create")
    public ApiResponse createCart(@RequestBody CartRequest cartRequest) {
          return cartService.createCart(cartRequest);
    }

    @RequestMapping(method= RequestMethod.GET, value = "/{cartId}/finalAmount")
    public ApiResponse fetchfinalAmpount(@PathVariable int cartId) {
        return cartService.calculateFinalAmount(cartId);
    }

    @RequestMapping(method= RequestMethod.GET, value = "/{cartId}")
    public ApiResponse getCartDetail(@PathVariable int cartId) {
        return cartService.getCartDetail(cartId);
    }
}
