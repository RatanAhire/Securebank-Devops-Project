package com.securebank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {

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

        String receiverAccount = request.getParameter("receiverAccount");
        String amount = request.getParameter("amount");

        if (receiverAccount == null || receiverAccount.trim().isEmpty()
                || amount == null || amount.trim().isEmpty()) {

            request.setAttribute("errorMessage",
                    "Please enter all required details.");

            request.getRequestDispatcher("transfer.jsp")
                    .forward(request, response);

            return;

        }

        request.setAttribute("successMessage",
                "₹ " + amount + " transferred successfully.");

        request.getRequestDispatcher("transfer.jsp")
                .forward(request, response);

    }

}