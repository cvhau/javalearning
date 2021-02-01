package com.cvhau.javalearning.junit.incontainertesting.servlet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class SampleServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    private SampleServlet servlet;

    @BeforeEach
    public void beforeEach() {
        servlet = new SampleServlet();
    }

    @Test
    public void isAuthenticated_GivenAuthenticatedHttpSession_GetTrue() {
        Mockito.when(session.getAttribute("authenticated")).thenReturn("true");
        Mockito.when(request.getSession(false)).thenReturn(session);

        boolean isAuthenticated = servlet.isAuthenticated(request);

        assertTrue(isAuthenticated);
    }

    @Test
    public void isAuthenticated_GivenUnauthenticatedHttpSession_GetFalse() {
        Mockito.when(session.getAttribute("authenticated")).thenReturn("false");
        Mockito.when(request.getSession(false)).thenReturn(session);

        boolean isAuthenticated = servlet.isAuthenticated(request);

        assertFalse(isAuthenticated);
    }

    @Test
    public void isAuthenticated_GivenMaliciousHttpSession_GetFalse() {
        Mockito.when(session.getAttribute("authenticated")).thenReturn("malicious value");
        Mockito.when(request.getSession(false)).thenReturn(session);

        boolean isAuthenticated = servlet.isAuthenticated(request);

        assertFalse(isAuthenticated);
    }

    @Test
    public void isAuthenticated_GivenNullHttpSession_GetFalse() {
        Mockito.when(request.getSession(false)).thenReturn(null);

        SampleServlet servlet = new SampleServlet();
        boolean isAuthenticated = servlet.isAuthenticated(request);

        assertFalse(isAuthenticated);
    }
}