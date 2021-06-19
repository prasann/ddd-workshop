package com.tw.domain.service;

import com.tw.domain.Price;

public class DiscountService {
    private static final int discount = 10;

    public static Price getDiscountedPrice(Price price){
        return price.applyDiscount(discount);
    }
}
