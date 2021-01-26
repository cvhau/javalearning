package com.cvhau.javalearning.junit.mocks.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    private final String senderId = "1";
    private final String beneficiaryId = "2";

    private MockAccountManager accountManager;

    @BeforeEach
    public void prepareAccountManager() {
        String senderAccountId = "account-1";
        String beneficiaryAccountId = "account-2";
        long senderAccountBalance = 200;
        long beneficiaryAccountBalance = 100;

        Account senderAccount = new Account(senderAccountId, senderAccountBalance);
        Account beneficiaryAccount = new Account(beneficiaryAccountId, beneficiaryAccountBalance);

        accountManager = new MockAccountManager();
        accountManager.addAccount(senderId, senderAccount);
        accountManager.addAccount(beneficiaryId, beneficiaryAccount);
    }

    @AfterEach
    public void releaseAccountManager() {
        accountManager.clear();
        accountManager = null;
    }

    @Test
    public void transfer_AmountOfMoneyFromSenderIdToBeneficiaryId_ThenCorrect() {
        long amount = 50;
        long expectedSenderBalance = 150;       // After transfer
        long expectedBeneficiaryBalance = 150;  // After transfer

        AccountService accountService = new AccountService();
        accountService.setAccountManager(accountManager);

        accountService.transfer(senderId, beneficiaryId, amount);

        Account senderAccount = accountManager.findAccountForUser(senderId);
        Account beneficiaryAccount = accountManager.findAccountForUser(beneficiaryId);

        assertAll(
                () -> assertEquals(expectedSenderBalance, senderAccount.getBalance()),
                () -> assertEquals(expectedBeneficiaryBalance, beneficiaryAccount.getBalance())
        );
    }

    @Test
    public void transfer_FromGivenNullSenderId_NullPointerException() {
        AccountService accountService = new AccountService();
        accountService.setAccountManager(accountManager);

        assertThrows(NullPointerException.class, () -> {
            accountService.transfer(null, beneficiaryId, 50);
        });
    }

    @Test
    public void transfer_ToGivenNullBeneficiaryId_NullPointerException() {
        AccountService accountService = new AccountService();
        accountService.setAccountManager(accountManager);

        assertThrows(NullPointerException.class, () -> {
            accountService.transfer(senderId, null, 50);
        });
    }
}
