package com.tw.domain;

import java.util.Currency;

public class Price {
    private final double value;
    private final Currency currency;

    public Price(double value) {
        this.value = value;
        this.currency = Currency.getInstance("INR");
    }

    public Price applyDiscount(int percentage) {
        int factor = (100 - percentage) / 100;
        return new Price(this.value * factor);
    }

    private Price add(Price price){
        return new Price(this.value + price.value);
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
