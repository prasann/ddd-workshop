package com.tw.domain;

import java.util.UUID;

public class Item {
    private String id;
    private final Product product;
    private final int quantity;

    public Item(Product product, int integer) {
        this.id = UUID.randomUUID().toString();
        this.product = product;
        this.quantity = integer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
