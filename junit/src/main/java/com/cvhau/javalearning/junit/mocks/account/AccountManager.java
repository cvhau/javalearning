package com.cvhau.javalearning.junit.mocks.account;

/**
 * An interface for all manager implementations
 */
public interface AccountManager {
    /**
     * Find account by given userId
     *
     * @param userId The user's ID
     * @return An account
     */
    public Account findAccountForUser(String userId);

    /**
     * Update the given account
     *
     * @param account The given account to update
     */
    public void updateAccount(Account account);
}
