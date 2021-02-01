package com.cvhau.javalearning.junit.mocks.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MockitoAccountServiceTest {
    private final String senderId = "1";
    private final String beneficiaryId = "2";

    @Mock
    private AccountManager accountManager;

    @Test
    public void transfer_AmountOfMoneyFromSenderIdToBeneficiaryId_ThenCorrect() {
        Account senderAccount = new Account("account-1", 200);
        Account beneficiaryAccount = new Account("account-2", 100);

        Mockito.when(accountManager.findAccountForUser(senderId)).thenReturn(senderAccount);
        Mockito.when(accountManager.findAccountForUser(beneficiaryId)).thenReturn(beneficiaryAccount);

        long amount = 50;
        long expectedSenderBalance = 150;       // After transfer
        long expectedBeneficiaryBalance = 150;  // After transfer

        AccountService accountService = new AccountService();
        accountService.setAccountManager(accountManager);

        accountService.transfer(senderId, beneficiaryId, amount);

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
