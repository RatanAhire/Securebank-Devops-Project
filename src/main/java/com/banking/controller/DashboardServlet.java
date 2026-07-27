package com.banking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DashboardServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check Session
        if (session == null || session.getAttribute("username") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        // Get Logged In User
        String username = (String) session.getAttribute("username");

        // Pass Data to JSP
        request.setAttribute("welcomeMessage",
                "Welcome, " + username + "!");

        request.setAttribute("accountNumber",
                "SB20260001");

        request.setAttribute("accountType",
                "Savings Account");

        request.setAttribute("availableBalance",
                "₹ 1,25,000");

        request.setAttribute("lastLogin",
                "Today");

        request.getRequestDispatcher("dashboard.jsp")
               .forward(request, response);

    }

}