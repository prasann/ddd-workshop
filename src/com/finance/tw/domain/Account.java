package com.finance.tw.domain;

import java.util.UUID;

public class Account {

    private UUID id;
    private String address;

    public Account(String address) {
        this.id = UUID.randomUUID();
        this.address = address;
    }

    public void updateAddress(String address){
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }
}
