package com.preplaced.retailStoreDiscount.Strategy;

import java.math.BigDecimal;
import com.preplaced.retailStoreDiscount.model.User;

public interface DiscountStrategy {
    BigDecimal calculateDiscount(BigDecimal amount);
}
