package com.banking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {

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

        List<String> transactions = new ArrayList<>();

        transactions.add("Deposit - ₹10,000");
        transactions.add("Withdraw - ₹2,000");
        transactions.add("Transfer - ₹5,000");

        request.setAttribute("transactions", transactions);

        request.getRequestDispatcher("transaction.jsp")
                .forward(request, response);

    }

}