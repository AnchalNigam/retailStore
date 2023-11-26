package com.preplaced.retailStoreDiscount.Strategy;
import com.preplaced.retailStoreDiscount.model.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.preplaced.retailStoreDiscount.utils.Constants.USER_TYPE;

public class PercentageDiscountStrategy {
    User user;
    public PercentageDiscountStrategy(User user) {
        this.user  =  user;
    }

    public BigDecimal calculateDiscount(BigDecimal amount) {
        BigDecimal discount = BigDecimal.valueOf(0);
        switch (this.user.getUserType()) {
            case affiliated:
                discount = (amount.multiply(new BigDecimal(0.1)));
                break;
            case platinum:
                discount = (amount.multiply(new BigDecimal(0.05)));
                break;
            case employee:
                discount = (amount.multiply(new BigDecimal(0.3)));
                break;
            default:
                break;
        }
        return discount.setScale(2, BigDecimal.ROUND_FLOOR);
    }
}
