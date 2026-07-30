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
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.banking.util.DBConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null) {
            response.sendRedirect("login.html");
            return;
        }

        email = email.trim();
        password = password.trim();

        if (email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("login.html");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {

            if (conn == null) {
                throw new Exception("Database Connection Failed");
            }

            String query =
                    "SELECT full_name, account_number, account_type, balance, password " +
                    "FROM users WHERE email=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String storedHash = rs.getString("password");

                if (BCrypt.checkpw(password, storedHash)) {

                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(30 * 60);

                    session.setAttribute("email", email);
                    session.setAttribute("fullName", rs.getString("full_name"));
                    session.setAttribute("accountNumber", rs.getString("account_number"));
                    session.setAttribute("accountType", rs.getString("account_type"));
                    session.setAttribute("balance", rs.getBigDecimal("balance"));

                    response.sendRedirect("DashboardServlet");
                    return;
                }
            }

            System.out.println("Invalid Login");
            response.sendRedirect("login.html?error=invalid");

        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/plain");
            e.printStackTrace(response.getWriter());
        }
    }
}