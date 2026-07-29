package com.banking.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({
        "/dashboard.html",
        "/profile.html",
        "/deposit.html",
        "/withdraw.html",
        "/transfer.html",
        "/transaction.html",
        "/settings.html",
        "/contact.html",
        "/DashboardServlet",
        "/DepositServlet",
        "/WithdrawServlet",
        "/TransferServlet",
        "/ProfileServlet"
})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        boolean loggedIn =
                session != null &&
                session.getAttribute("username") != null;

        if (loggedIn) {

            chain.doFilter(request, response);

        } else {

            res.sendRedirect(req.getContextPath() + "/login.html");

        }

    }

    @Override
    public void destroy() {

    }

}