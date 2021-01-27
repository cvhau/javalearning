package com.cvhau.javalearning.junit.mocks.account;

import com.cvhau.javalearning.junit.mocks.configurations.Configuration;
import com.cvhau.javalearning.junit.mocks.configurations.MockConfiguration;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class MockitoDefaultAccountManagerTest {
    @Mock
    private Logger logger;

    @Mock
    private Configuration configuration;

    @Test
    void findAccountForUser() {
        // Use Mockito instead of creating MockLogger object manually.
        // Note: with a "void method", we can omit this method call,
        //       because Mockito will "do nothing" on this as default behavior.
        Mockito.doNothing().when(logger).debug("Getting account for user [123456]");

        // Use Mockito instead of creating MockConfiguration object manually.
        Mockito.when(configuration.getSQL("FIND_ACCOUNT_FOR_USER"))
                .thenReturn("SELECT * FROM accounts WHERE user_id='123456' LIMIT 1");

        DefaultAccountManager accountManager = new DefaultAccountManager(logger, configuration);

        Account account = accountManager.findAccountForUser("123456");

        assertNull(account);
    }

    @Test
    void updateAccount() {
    }
}