package com.cvhau.javalearning.junit.mocks.account;

import com.cvhau.javalearning.junit.mocks.configurations.Configuration;
import com.cvhau.javalearning.junit.mocks.configurations.MockConfiguration;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultAccountManagerTest {

    @Test
    void findAccountForUser() {
        Logger logger = new MockLogger();
        Configuration configuration = new MockConfiguration();

        DefaultAccountManager accountManager = new DefaultAccountManager(logger, configuration);

        Account account = accountManager.findAccountForUser("123456");

        assertNull(account);
    }

    @Test
    void updateAccount() {
    }
}