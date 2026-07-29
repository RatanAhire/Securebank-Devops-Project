package com.banking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SettingsServlet")
public class SettingsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {

            response.sendRedirect("login.html");
            return;

        }

        request.setAttribute("successMessage",
                "Settings updated successfully.");

        request.getRequestDispatcher("settings.html")
                .forward(request, response);

    }

}