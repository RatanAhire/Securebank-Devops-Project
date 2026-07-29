package com.banking.servlet;

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

        // Null Validation
        if (firstName == null || lastName == null || email == null ||
            mobile == null ||
            password == null || confirmPassword == null) {
            response.sendRedirect("register.html");
            return;
        }

        // Trim inputs
        firstName = firstName.trim();
        lastName = lastName.trim();
        email = email.trim();
        mobile = mobile.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();

        // Empty Validation
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
            mobile.isEmpty() || 
            password.isEmpty() || confirmPassword.isEmpty()) {
            response.sendRedirect("register.html");
            return;
        }

        // Combine name after validation
        String fullName = firstName + " " + lastName;

        // Password match check
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.html");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {

            // Check if username already exists
            String checkQuery = "SELECT id FROM users WHERE username = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, username);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    // Username already taken
                    response.sendRedirect("register.html");
                    return;
                }
            }

            // Hash the password before storing
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            // Insert new user
            String insertQuery = "INSERT INTO users (username, password, email, full_name, mobile, balance) " +
                                  "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, hashedPassword);
                insertStmt.setString(3, email);
                insertStmt.setString(4, fullName);
                insertStmt.setString(5, mobile);
                insertStmt.setBigDecimal(6, java.math.BigDecimal.ZERO);

                insertStmt.executeUpdate();
            }

            response.sendRedirect("login.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.html");
        }
    }
}