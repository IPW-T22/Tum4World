package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.UserManager;
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
        UserManager userManager = new UserManager(username);
        if(userManager.signIn(request, username, hashPassword)) {
            if(userManager.user.getRuolo()== Utente.Ruolo.SIMPATIZZANTE){
                response.sendRedirect("simpatizzante?id="+userManager.user.getKey());
            }
            else{
                response.sendRedirect("aderente?id="+userManager.user.getKey());
            }
        }
        else
            response.sendRedirect("signin?error=true");
    }
}