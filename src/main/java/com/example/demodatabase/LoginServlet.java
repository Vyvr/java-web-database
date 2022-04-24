package com.example.demodatabase;

import DBService.Validation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("textLogin");
        String password = request.getParameter("textPassword");

        if(Validation.isAuthorized(login, password)) {
            HttpSession session = request.getSession(false);
            session.setAttribute("user", login);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("loginError", "Invalid user or password");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
