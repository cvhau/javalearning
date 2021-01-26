package com.cvhau.javalearning.junit.mocks.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * ConnectionFactory interface
 */
public interface ConnectionFactory {
    /**
     * Read data from given URL object
     *
     * @param url The given URL
     * @return InputStream for reading data from the connection.
     * @throws IOException If an I/O exception occurs
     */
    public InputStream getData(URL url) throws IOException;
}
