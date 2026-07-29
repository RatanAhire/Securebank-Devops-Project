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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            response.sendRedirect("login.html");
            return;
        }

        username = username.trim();
        password = password.trim();

        if (username.isEmpty() || password.isEmpty()) {
            response.sendRedirect("login.html");
            return;
        }

        String query = "SELECT password FROM users WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");

                if (BCrypt.checkpw(password, storedHash)) {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(30 * 60);
                    session.setAttribute("username", username);
                    session.setAttribute("role", "Customer");

                    response.sendRedirect("dashboard.html");
                    return;
                }
            }

            // Invalid username or password
            response.sendRedirect("login.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.html");
        }
    }
}