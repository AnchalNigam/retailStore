package com.preplaced.retailStoreDiscount.Service;

import com.preplaced.retailStoreDiscount.pojo.ApiResponse;
import com.preplaced.retailStoreDiscount.pojo.CartRequest;
import com.preplaced.retailStoreDiscount.repositories.CartRepository;
import com.preplaced.retailStoreDiscount.repositories.ItemRepository;
import com.preplaced.retailStoreDiscount.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.preplaced.retailStoreDiscount.model.*;


import java.math.BigDecimal;
import java.util.*;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    public ApiResponse createCart(CartRequest cartRequest) {
        Cart cart = new Cart();
        System.out.println(cartRequest.getItemList() + "print======>");
        User user = userRepository.findById(cartRequest.getUserId());
        System.out.println(user);
        cart.setUserId(user);
        List<Item> items = itemRepository.findAllByIdIn(cartRequest.getItemList());
        for(Item item: items) {
            cart.addItem(item);
        }
        cartRepository.save(cart);
        return new ApiResponse(HttpStatus.CREATED, "Cart created successfully!", null);

    }

    public ApiResponse getCartDetail(int cartId) {
        Cart cart = cartRepository.findById(cartId);
        return new ApiResponse(HttpStatus.FOUND, "Cart details fetched Successfully!", cart);
    }

    public ApiResponse calculateFinalAmount(int cartId) {
        Cart cart = cartRepository.findById(cartId);
        BigDecimal discount = new DiscountService(cart).calculateDiscount();
        BigDecimal finalAmount=  cart.getTotalBill().subtract(discount);
        return new ApiResponse(HttpStatus.FOUND, "Cart details fetched Successfully!", finalAmount);
    }
}
