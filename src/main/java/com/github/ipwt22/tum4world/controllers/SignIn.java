package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.Utente;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "signin", value = "/signin")
public class SignIn extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/login.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String hashPassword = request.getParameter("hashPassword");
        Utente user = new Utente();
        if(user.login(request, username, hashPassword)) {
            System.out.println("CHIAVE:" + user.getKey());
            response.sendRedirect("dashboard?id=" + user.getKey());
        }
        else
            response.sendRedirect("signin?error=true");
    }
}