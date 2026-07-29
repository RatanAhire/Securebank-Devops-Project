package com.banking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get Form Data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Null Validation
        if (username == null || password == null) {

            response.sendRedirect("login.html");
            return;

        }

        // Remove Extra Spaces
        username = username.trim();
        password = password.trim();

        // Empty Validation
        if (username.isEmpty() || password.isEmpty()) {

            response.sendRedirect("login.html");
            return;

        }

        // ==========================================
        // Temporary Login (Without Database)
        // Username : admin
        // Password : admin123
        // ==========================================

        if ("admin".equals(username)
                && "admin123".equals(password)) {

            HttpSession session = request.getSession();

            session.setMaxInactiveInterval(30 * 60);

            session.setAttribute("username", username);
            session.setAttribute("role", "Customer");

            // Redirect to Dashboard
            response.sendRedirect("dashboard.html");

        } else {

            response.sendRedirect("login.html");

        }

    }

}