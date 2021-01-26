package com.cvhau.javalearning.junit.mocks.account;

import com.cvhau.javalearning.junit.mocks.configurations.Configuration;
import com.cvhau.javalearning.junit.mocks.configurations.DefaultConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultAccountManager implements AccountManager {
    private final Logger logger;
    private final Configuration configuration;

    public DefaultAccountManager() {
        this(
                LogManager.getLogger(DefaultAccountManager.class.getName()),
                new DefaultConfiguration("technical")
        );
    }

    public DefaultAccountManager(Logger logger, Configuration configuration) {
        this.logger = logger;
        this.configuration = configuration;
    }

    @Override
    public Account findAccountForUser(String userId) {
        logger.debug("Getting account for user [" + userId + "]");
        String sql = configuration.getSQL("FIND_ACCOUNT_FOR_USER");

        // Some code logic to load a user account using JDBC
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        // Perform database access here
    }
}
