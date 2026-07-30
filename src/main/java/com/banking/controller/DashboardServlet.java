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

import com.banking.util.DBConnection;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("email") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String email = (String) session.getAttribute("email");

        try (Connection conn = DBConnection.getConnection()) {

            String sql =
                    "SELECT id, username, full_name, email, balance FROM users WHERE email=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String fullName = rs.getString("full_name");
                double balance = rs.getDouble("balance");

                // Generate Account Number
                String accountNumber = "SB2026" + String.format("%06d", id);

                request.setAttribute("welcomeMessage",
                        "Welcome, " + fullName);

                request.setAttribute("accountNumber",
                        accountNumber);

                request.setAttribute("username",
                        username);

                request.setAttribute("email",
                        email);

                request.setAttribute("availableBalance",
                        "₹ " + balance);

                request.setAttribute("accountType",
                        "Savings Account");

                request.setAttribute("lastLogin",
                        "Today");

                request.getRequestDispatcher("dashboard.jsp")
                       .forward(request, response);

            } else {

                response.sendRedirect("login.html");

            }

        } catch (Exception e) {

            e.printStackTrace();
            response.sendRedirect("login.html");

        }
    }
}