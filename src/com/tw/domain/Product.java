package com.tw.domain;

public class Product {
    private final String name;
    private final Weight weight;
    private final Price price;

    public Product(String name, Weight weight, Price price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Weight getWeight() {
        return weight;
    }

    public Price getPrice() {
        return price;
    }
}
