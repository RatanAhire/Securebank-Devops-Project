package com.securebank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {

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

        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        if (subject == null || subject.trim().isEmpty()
                || message == null || message.trim().isEmpty()) {

            request.setAttribute("errorMessage",
                    "Please fill all fields.");

            request.getRequestDispatcher("contact.jsp")
                    .forward(request, response);

            return;

        }

        request.setAttribute("successMessage",
                "Your message has been sent successfully.");

        request.getRequestDispatcher("contact.jsp")
                .forward(request, response);

    }

}