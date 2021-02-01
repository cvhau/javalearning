package com.cvhau.javalearning.junit.mocks.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WebClient {
    private final ConnectionFactory connectionFactory;

    public WebClient() {
        this(new URLConnectionFactory());
    }

    public WebClient(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Open connection then get content from given URL
     *
     * @param url   The given URL object
     * @return      The content from URL
     * @throws IOException If an I/O exception occurs
     */
    public String getContent(URL url) throws IOException {
        try (InputStream inputStream = connectionFactory.getData(url)) {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int b = -1;
                while ((b = inputStream.read()) != -1) {
                    outputStream.write(b);
                }
                return outputStream.toString();
            }
        }
    }
}
