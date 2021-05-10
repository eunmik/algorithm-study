package com.eunmi.TDD;

public class Account {
    private int balance;
    public Account(int money) {
        this.balance = money;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int mooney) {
        this.balance += mooney;
    }

    public void withdraw(int money) {
        this.balance -= money;
    }
}
