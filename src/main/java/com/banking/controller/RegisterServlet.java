package com.banking.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.banking.util.DBConnection;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (firstName == null || lastName == null || email == null ||
            mobile == null ||
            password == null || confirmPassword == null) {
            response.sendRedirect("register.html");
            return;
        }

        firstName = firstName.trim();
        lastName = lastName.trim();
        email = email.trim();
        mobile = mobile.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
            mobile.isEmpty() ||
            password.isEmpty() || confirmPassword.isEmpty()) {
            response.sendRedirect("register.html");
            return;
        }

        String fullName = firstName + " " + lastName;

        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.html");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {

            String checkQuery = "SELECT id FROM users WHERE email = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, email);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    response.sendRedirect("register.html");
                    return;
                }
            }

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            String insertQuery = "INSERT INTO users (email, password, full_name, mobile, balance) " +
                                  "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, email);
                insertStmt.setString(2, hashedPassword);
                insertStmt.setString(3, fullName);
                insertStmt.setString(4, mobile);
                insertStmt.setBigDecimal(5, java.math.BigDecimal.ZERO);

                insertStmt.executeUpdate();
            }

            response.sendRedirect("login.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.html");
        }
    }
}   