package com.odde.cucumber.api.dto;

public class Account {
    private String name;
    private Integer balance;

    public Account() {
    }

    public Account(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object obj) {
        Account another = (Account)obj;
        return name.equals(another.name) && balance.equals(another.balance);
    }
}
