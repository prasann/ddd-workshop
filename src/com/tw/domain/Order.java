package com.tw.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class Order {

    private String id;
    private final List<Item> orderItems;

    public Order(List<Item> cartItems) {
        id = UUID.randomUUID().toString();
        orderItems = new ArrayList<>(cartItems);
    }

    public List<Item> getOrderItems() {
        return unmodifiableList(orderItems);
    }
}
