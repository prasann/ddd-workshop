package com.tw.domain;

import java.util.*;

import static java.util.Collections.unmodifiableList;

public class Cart {

    private String id;
    private final List<Item> cartItems;
    private final Set<Product> removedProductLog;

    public Cart() {
        id = UUID.randomUUID().toString();
        cartItems = new ArrayList<>();
        removedProductLog = new HashSet<>();
    }

    public void addProduct(Product product, int quantity) {
        Item item = new Item(product, quantity);
        cartItems.add(item);
    }

    public void remove(Product product) {
        Optional<Item> optionalItem =
                cartItems.stream().filter(item -> item.getProduct().equals(product))
                        .findFirst();
        optionalItem.ifPresent(item -> {
            removedProductLog.add(product);
            cartItems.remove(item);
        });
    }

    public Set<Product> getRemovedProductLog() {
        return removedProductLog;
    }

    public List<Item> getCartItems() {
        return unmodifiableList(cartItems);
    }
}
