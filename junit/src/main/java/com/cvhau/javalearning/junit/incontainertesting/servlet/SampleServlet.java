package com.cvhau.javalearning.junit.incontainertesting.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SampleServlet extends HttpServlet {
    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Checks if the authenticated property has been setup and returns its boolean value.
     *
     * @param request HttpServletRequest implementation.
     * @return True if authenticated, otherwise false.
     */
    public boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String authenticationAttribute = (String) session.getAttribute("authenticated");
            return Boolean.parseBoolean(authenticationAttribute);
        }
        return false;
    }
}
