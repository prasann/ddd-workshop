package com.finance.tw.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    private final UUID id;
    private final List<Account> accounts;
    private String address;

    public Customer(String address) {
        this.address = address;
        this.id = UUID.randomUUID();
        this.accounts = new ArrayList();
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public void updateAddress(String newAddress){
        this.address = newAddress;
        accounts.forEach(account -> account.updateAddress(address));
    }

    public String getAddress() {
        return this.address;
    }
}
