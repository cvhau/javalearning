package com.cvhau.javalearning.junit.mocks.account;

import java.util.Objects;

public class AccountService {
    /**
     * The AccountManager implementation to user
     */
    private AccountManager accountManager;

    /**
     * A setter method to set AccountManager implementation.
     *
     * @param accountManager The AccountManager implementation
     */
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * A transfer method which transfers the amount of money
     * from the account with senderId to account of beneficiaryId
     *
     * @param senderId      The sender account's ID
     * @param beneficiaryId The beneficiary account's ID
     * @param amount        The amount of money to transfer
     */
    public void transfer(String senderId, String beneficiaryId, long amount) {
        Objects.requireNonNull(senderId, "The senderId cannot be null");
        Objects.requireNonNull(beneficiaryId, "The beneficiaryId cannot be null");

        Account sender = accountManager.findAccountForUser(senderId);
        Account beneficiary = accountManager.findAccountForUser(beneficiaryId);

        sender.debit(amount);
        beneficiary.credit(amount);

        accountManager.updateAccount(sender);
        accountManager.updateAccount(beneficiary);
    }
}
