package com.cvhau.javalearning.junit.mocks.account;

import java.util.Objects;

/**
 * Account POJO to hold the bank account object.
 */
public class Account {
    private final String accountId;
    private long balance;

    public Account(String accountId, long balance) {
        Objects.requireNonNull(accountId, "The accountId cannot be null");
        if (balance < 0) {
            throw new IllegalArgumentException("The balance cannot be negative.");
        }
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void debit(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount of money cannot be negative.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("The amount of money cannot be larger then the balance.");
        }
        balance -= amount;
    }

    public void credit(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount of money cannot be negative.");
        }
        balance += amount;
    }

    public long getBalance() {
        return balance;
    }
}
