package com.cvhau.javalearning.junit.mocks.web;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebClientTest {

    @Test
    public void getContent_FromGivenURL_ThenCorrect() throws IOException {
        String url = "http://nothing.org";
        String expectedContent = "It works";

        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory(expectedContent);
        WebClient webClient = new WebClient(mockConnectionFactory);

        String content = webClient.getContent(new URL(url));

        assertEquals(expectedContent, content);
    }
}