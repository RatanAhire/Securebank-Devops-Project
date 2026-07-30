package com.banking.controller;

import java.io.IOException;
import java.math.BigDecimal;
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

        if (firstName == null || lastName == null || email == null
                || mobile == null || password == null || confirmPassword == null) {

            response.sendRedirect("register.html");
            return;
        }

        firstName = firstName.trim();
        lastName = lastName.trim();
        email = email.trim();
        mobile = mobile.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()
                || mobile.isEmpty() || password.isEmpty()
                || confirmPassword.isEmpty()) {

            response.sendRedirect("register.html");
            return;
        }

        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.html");
            return;
        }

        String fullName = firstName + " " + lastName;

        try (Connection conn = DBConnection.getConnection()) {

            if (conn == null) {
                throw new Exception("Database Connection Failed");
            }

            System.out.println("Database Connected Successfully");

            // Check existing email
            String checkSql = "SELECT id FROM users WHERE email=?";

            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, email);

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Email Already Exists");
                response.sendRedirect("register.html");
                return;
            }

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            String insertSql =
                    "INSERT INTO users(username,email,password,full_name,mobile,balance) "
                    + "VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(insertSql);

            // Username generated from email
            String username = email.substring(0, email.indexOf("@"));

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, hashedPassword);
            ps.setString(4, fullName);
            ps.setString(5, mobile);
            ps.setBigDecimal(6, BigDecimal.ZERO);

            int rows = ps.executeUpdate();

            System.out.println("Rows Inserted : " + rows);

            if (rows > 0) {
                response.sendRedirect("login.html");
            } else {
                response.sendRedirect("register.html");
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/plain");

            e.printStackTrace(response.getWriter());
        }
    }
}