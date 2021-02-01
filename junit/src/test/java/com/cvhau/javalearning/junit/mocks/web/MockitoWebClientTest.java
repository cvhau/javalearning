package com.cvhau.javalearning.junit.mocks.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MockitoWebClientTest {
    @Mock
    private ConnectionFactory connectionFactory;

    @Test
    public void getContent_FromGivenURL_ThenCorrect() throws IOException {
        URL url = new URL("http://nothing.org");
        String expectedContent = "It works";

        Mockito.when(connectionFactory.getData(url)).thenReturn(new ByteArrayInputStream(expectedContent.getBytes()));
        WebClient webClient = new WebClient(connectionFactory);

        String content = webClient.getContent(url);

        assertEquals(expectedContent, content);
    }
}