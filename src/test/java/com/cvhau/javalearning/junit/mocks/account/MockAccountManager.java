package com.cvhau.javalearning.junit.mocks.account;

import java.util.Hashtable;
import java.util.Map;

public class MockAccountManager implements AccountManager {
    private final Map<String, Account> accounts = new Hashtable<>();

    public void addAccount(String userId, Account account) {
        accounts.put(userId, account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return accounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
        // Do nothing
    }

    public void clear() {
        accounts.clear();
    }
}
