package com.preplaced.retailStoreDiscount.pojo;

import java.util.List;

public class CartRequest {
    private Long userId;
    private List<Long> itemList;

    public Long getUserId() {
        return userId;
    }

    public List<Long> getItemList() {
        return itemList;
    }
}
