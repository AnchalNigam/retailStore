package com.preplaced.retailStoreDiscount.Service;

import com.preplaced.retailStoreDiscount.Strategy.FlatDiscountStrategy;
import com.preplaced.retailStoreDiscount.Strategy.PercentageDiscountStrategy;
import com.preplaced.retailStoreDiscount.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.preplaced.retailStoreDiscount.model.*;

import java.math.BigDecimal;

@Service
public class DiscountService {

    Cart cart;
    public DiscountService() {

    }

    public DiscountService(Cart cart) {
        this.cart = cart;
    }

    public BigDecimal calculateDiscount() {
        BigDecimal flatDiscount = new FlatDiscountStrategy().calculateDiscount(cart.getTotalBill());
        System.out.println(flatDiscount + "flatdiscount==>");
        BigDecimal percentDiscountApplicableAmount = getApplicablePercentageDiscountAmount();

        BigDecimal percentageDiscount = new PercentageDiscountStrategy(cart.getCreatedBy()).calculateDiscount(percentDiscountApplicableAmount);
        System.out.println(percentageDiscount + "percentge=>");
        return flatDiscount.add(percentageDiscount);
    }


    public BigDecimal getApplicablePercentageDiscountAmount() {
        BigDecimal applicableAmount = new BigDecimal(0);
        for(Item item: cart.getItems()) {

            if(item.getItemType() != Constants.ITEM_TYPE.GROCERY) {
                applicableAmount = applicableAmount.add(item.getPrice());
            }
        }
        return applicableAmount;
    }
}
