package com.cvhau.javalearning.junit.mocks.configurations;

public interface Configuration {
    /**
     * Get the SQL query string from the configuration.
     *
     * @param key The given key
     * @return SQL query string
     */
    public String getSQL(String key);
}
