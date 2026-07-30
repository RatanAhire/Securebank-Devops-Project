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

        String accountType = request.getParameter("accountType");
        String aadhaar = request.getParameter("aadhaar");
        String address = request.getParameter("address");

        if (firstName == null || lastName == null || email == null
                || mobile == null || password == null
                || confirmPassword == null) {

            response.sendRedirect("register.html");
            return;
        }

        firstName = firstName.trim();
        lastName = lastName.trim();
        email = email.trim();
        mobile = mobile.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();

        if (accountType == null)
            accountType = "Savings Account";

        if (aadhaar == null)
            aadhaar = "";

        if (address == null)
            address = "";

        if (firstName.isEmpty() || lastName.isEmpty()
                || email.isEmpty() || mobile.isEmpty()
                || password.isEmpty()
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

            String checkSql = "SELECT id FROM users WHERE email=?";

            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

                checkStmt.setString(1, email);

                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    System.out.println("Email Already Exists");
                    response.sendRedirect("register.html?error=email");
                    return;
                }
            }

            String hashedPassword =
                    BCrypt.hashpw(password, BCrypt.gensalt());

            String accountNumber =
                    "SB2026" + String.format("%06d",
                    (int) (Math.random() * 1000000));

            String username =
                    email.substring(0, email.indexOf("@"));

            String insertSql =
                    "INSERT INTO users "
                    + "(username,password,full_name,mobile,email,balance,"
                    + "account_number,account_type,aadhaar,address) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement insertStmt =
                    conn.prepareStatement(insertSql)) {

                insertStmt.setString(1, username);
                insertStmt.setString(2, hashedPassword);
                insertStmt.setString(3, fullName);
                insertStmt.setString(4, mobile);
                insertStmt.setString(5, email);
                insertStmt.setBigDecimal(6, BigDecimal.ZERO);
                insertStmt.setString(7, accountNumber);
                insertStmt.setString(8, accountType);
                insertStmt.setString(9, aadhaar);
                insertStmt.setString(10, address);

                int rows = insertStmt.executeUpdate();

                System.out.println("Rows Inserted : " + rows);

                if (rows > 0) {
                    response.sendRedirect("login.html?success=1");
                } else {
                    response.sendRedirect("register.html?error=insert");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/plain");
            e.printStackTrace(response.getWriter());
        }
    }
}