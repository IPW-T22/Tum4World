package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.DB;
import com.github.ipwt22.tum4world.models.Utente;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/login.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String hashPassword = request.getParameter("hashPassword");
        Utente user = DB.getUserFromUsername(username);
        if(user!=null && user.login(request, username, hashPassword)) {
            response.sendRedirect("dashboard?token=" + user.getToken());
        }
        else {
            response.sendRedirect("login?error=true");
        }
    }
}