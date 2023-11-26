package com.preplaced.retailStoreDiscount.Strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FlatDiscountStrategy {
    public BigDecimal calculateDiscount(BigDecimal amount) {
        return amount.divide(new BigDecimal(100), 2, RoundingMode.FLOOR).multiply(new BigDecimal(5));
    }
}
