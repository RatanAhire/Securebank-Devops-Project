package com.securebank.filter;

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
        "/dashboard.jsp",
        "/profile.jsp",
        "/deposit.jsp",
        "/withdraw.jsp",
        "/transfer.jsp",
        "/transaction.jsp",
        "/settings.jsp",
        "/contact.jsp",
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

            res.sendRedirect(req.getContextPath() + "/login.jsp");

        }

    }

    @Override
    public void destroy() {

    }

}