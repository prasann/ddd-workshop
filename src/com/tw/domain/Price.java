package com.tw.domain;

import java.util.Currency;

public class Price {
    private final double value;
    private final Currency currency;

    public Price(double value) {
        this.value = value;
        this.currency = Currency.getInstance("INR");
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
