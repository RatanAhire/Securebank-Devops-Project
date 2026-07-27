package com.banking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        request.setAttribute("customerName", "Ratan Ahire");
        request.setAttribute("accountNumber", "SB20260001");
        request.setAttribute("email", "ratan@example.com");
        request.setAttribute("mobile", "9876543210");
        request.setAttribute("accountType", "Savings");
        request.setAttribute("branch", "Mumbai Main Branch");

        request.getRequestDispatcher("profile.jsp")
               .forward(request, response);
    }
}