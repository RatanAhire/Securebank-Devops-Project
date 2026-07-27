package com.banking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String amount = request.getParameter("amount");

        if (amount == null || amount.trim().isEmpty()) {

            request.setAttribute("errorMessage",
                    "Please enter withdrawal amount.");

            request.getRequestDispatcher("withdraw.jsp")
                   .forward(request, response);

            return;
        }

        request.setAttribute("successMessage",
                "₹ " + amount + " withdrawn successfully.");

        request.getRequestDispatcher("withdraw.jsp")
               .forward(request, response);
    }
}