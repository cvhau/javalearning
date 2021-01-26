package com.cvhau.javalearning.junit.mocks.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MockConnectionFactory implements ConnectionFactory {
    private final String mockContent;

    public MockConnectionFactory(String mockContent) {
        this.mockContent = mockContent;
    }

    @Override
    public InputStream getData(URL url) throws IOException {
        byte[] bytes = mockContent.getBytes();
        return new ByteArrayInputStream(bytes);
    }
}
