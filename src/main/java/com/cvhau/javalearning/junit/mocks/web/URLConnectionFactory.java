package com.cvhau.javalearning.junit.mocks.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionFactory implements ConnectionFactory {

    @Override
    public InputStream getData(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        return connection.getInputStream();
    }
}
