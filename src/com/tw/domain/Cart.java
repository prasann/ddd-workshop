package com.tw.domain;

import java.util.*;

import static java.util.Collections.unmodifiableList;

public class Cart {

    private final String id;
    private boolean checkedOut;
    private final List<Item> cartItems;
    private final Set<Product> removedProductLog;

    public Cart() {
        checkedOut = false;
        id = UUID.randomUUID().toString();
        cartItems = new ArrayList<>();
        removedProductLog = new HashSet<>();
    }

    public void addProduct(Product product, int quantity) {
        if (checkedOut) {
            return;
        }
        Item item = new Item(product, quantity);
        cartItems.add(item);
    }

    public void remove(Product product) {
        if (checkedOut) {
            return;
        }
        Optional<Item> optionalItem =
                cartItems.stream().filter(item -> item.getProduct().equals(product))
                        .findFirst();
        optionalItem.ifPresent(item -> {
            removedProductLog.add(product);
            cartItems.remove(item);
        });
    }

    public Order checkout(){
        checkedOut = true;
        return new Order(cartItems);
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public Set<Product> getRemovedProductLog() {
        return removedProductLog;
    }

    public List<Item> getCartItems() {
        return unmodifiableList(cartItems);
    }
}
