package com.tw.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;

public class Order {

    private Price amount;
    private String id;
    private final List<Item> orderItems;

    public Order(List<Item> cartItems) {
        id = UUID.randomUUID().toString();
        orderItems = new ArrayList<>(cartItems);
        this.amount = orderItems.stream()
                .map(Item::getPrice)
                .reduce(new Price(0), Price::add);
    }

    public Price getAmount() {
        return amount;
    }

    public List<Item> getOrderItems() {
        return unmodifiableList(orderItems);
    }
}
