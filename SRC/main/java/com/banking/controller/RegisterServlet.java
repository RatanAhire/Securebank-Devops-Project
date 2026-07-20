package com.securebank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Read Form Data
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Null Validation
        if (fullName == null || email == null ||
            mobile == null || username == null ||
            password == null || confirmPassword == null) {

            response.sendRedirect("register.jsp");
            return;
        }

        // Remove Extra Spaces
        fullName = fullName.trim();
        email = email.trim();
        mobile = mobile.trim();
        username = username.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();

        // Empty Validation
        if (fullName.isEmpty() ||
            email.isEmpty() ||
            mobile.isEmpty() ||
            username.isEmpty() ||
            password.isEmpty() ||
            confirmPassword.isEmpty()) {

            request.setAttribute("errorMessage",
                    "All fields are required.");

            request.getRequestDispatcher("register.jsp")
                   .forward(request, response);

            return;
        }

        // Password Match Validation
        if (!password.equals(confirmPassword)) {

            request.setAttribute("errorMessage",
                    "Password and Confirm Password do not match.");

            request.getRequestDispatcher("register.jsp")
                   .forward(request, response);

            return;
        }

        // ============================================
        // Temporary Registration (Without Database)
        // ============================================

        request.setAttribute("successMessage",
                "Registration Successful! Please Login.");

        request.getRequestDispatcher("login.jsp")
               .forward(request, response);

    }

}