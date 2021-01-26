package com.cvhau.javalearning.junit.mocks.account;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void constructor_FromGivenAccountIdAndBalance_ThenCorrect() throws NoSuchFieldException {
        String accountId = "15";
        long balance = 100;

        Account account = new Account(accountId, balance);
        Class<?> clazz = account.getClass();

        Field accountIdField = clazz.getDeclaredField("accountId");
        Field balanceField = clazz.getDeclaredField("balance");
        accountIdField.setAccessible(true);
        balanceField.setAccessible(true);

        assertAll(
                () -> assertEquals(accountId, accountIdField.get(account)),
                () -> assertEquals(balance, balanceField.get(account))
        );
    }

    @Test
    public void constructor_FromGivenNullAccountId_NullPointerException() {
        long balance = 100;

        assertThrows(NullPointerException.class, () -> {
            @SuppressWarnings("unused")
            Account account = new Account(null, balance);
        });
    }

    @Test
    public void constructor_FromGivenNegativeBalance_IllegalArgumentException() {
        String accountId = "15";
        long balance = -1;

        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Account account = new Account(accountId, balance);
        });
    }

    @Test
    public void getAccountId_GivenObjectThenGetTheAccountId_ThenCorrect() {
        String accountId = "15";
        long balance = 100;

        Account account = new Account(accountId, balance);

        assertEquals(accountId, account.getAccountId());
    }

    @Test
    public void debit_AmountOfMoney_ThenGetCorrectBalance() throws NoSuchFieldException, IllegalAccessException {
        String accountId = "15";
        long balance = 100;
        long amount = 25;
        long expectedRemainingBalance = 75;

        Account account = new Account(accountId, balance);
        account.debit(amount);

        Class<?> clazz = account.getClass();
        Field balanceField = clazz.getDeclaredField("balance");
        balanceField.setAccessible(true);

        assertEquals(expectedRemainingBalance, balanceField.get(account));
    }

    @Test
    public void debit_ZeroAmountOfMoney_ThenGetCorrectBalance() throws NoSuchFieldException, IllegalAccessException {
        String accountId = "15";
        long balance = 100;
        long amount = 0;
        long expectedRemainingBalance = 100;

        Account account = new Account(accountId, balance);
        account.debit(amount);

        Class<?> clazz = account.getClass();
        Field balanceField = clazz.getDeclaredField("balance");
        balanceField.setAccessible(true);

        assertEquals(expectedRemainingBalance, balanceField.get(account));
    }

    @Test
    public void debit_NegativeAmountOfMoney_IllegalArgumentException() {
        String accountId = "15";
        long balance = 100;
        long amount = -1;

        Account account = new Account(accountId, balance);

        assertThrows(IllegalArgumentException.class, () -> account.debit(amount));
    }

    @Test
    public void debit_AmountOfMoneyLargerThenBalance_IllegalArgumentException() {
        String accountId = "15";
        long balance = 100;
        long amount = 110;

        Account account = new Account(accountId, balance);

        assertThrows(IllegalArgumentException.class, () -> account.debit(amount));
    }

    @Test
    public void credit_AmountOfMoney_ThenGetCorrectBalance() throws NoSuchFieldException, IllegalAccessException {
        String accountId = "15";
        long balance = 100;
        long amount = 25;
        long expectedRemainingBalance = 125;

        Account account = new Account(accountId, balance);
        account.credit(amount);

        Class<?> clazz = account.getClass();
        Field balanceField = clazz.getDeclaredField("balance");
        balanceField.setAccessible(true);

        assertEquals(expectedRemainingBalance, balanceField.get(account));
    }

    @Test
    public void credit_NegativeAmountOfMoney_IllegalArgumentException() {
        String accountId = "15";
        long balance = 100;
        long amount = -25;

        Account account = new Account(accountId, balance);
        assertThrows(IllegalArgumentException.class, () -> account.credit(amount));
    }

    @Test
    public void getBalance_GivenAccountObject_ThenGetCorrectBalance() {
        String accountId = "15";
        long balance = 100;

        Account account = new Account(accountId, balance);

        assertEquals(balance, account.getBalance());
    }
}