package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.UtenteHelper;
import com.github.ipwt22.tum4world.models.Utente;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/login.jsp").forward(request, response);
        System.out.println("CIAO");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("VA");
        String username = request.getParameter("username");
        String password = request.getParameter("hashPassword");
        String cookieAcceptedVal = UtenteHelper.get_value_from_cookie("cookieAccepted", request);
        String token;
        HttpSession session = null;
        Utente user = null;
        System.err.println("Login-> username: " + username + " password: " + password + " cookieAcceptedVal: " + cookieAcceptedVal);

        if((user=validate(username, password))!=null) {
            token = UtenteHelper.generateUniqueToken(username);
            UtenteHelper.setKeyOf(DatabaseHelper.getConnection(), username, token);
            if(cookieAcceptedVal!=null && cookieAcceptedVal.equals("true")) {
                session = request.getSession();
                session.setAttribute("BeanUtente", user);
                session.setAttribute("token", token);
                response.sendRedirect("dashboard");
            }
            else
                response.sendRedirect("dashboard?token="+token);
        }
        else {
            response.sendRedirect("login?error=true");
        }
    }

    private Utente validate(String username, String password){
        Utente user = UtenteHelper.fromUsername(DatabaseHelper.getConnection(), username);
        if(user!=null && username.equals(user.getUsername()) && password.equals(user.getPassword()))
            return user;
        return null;
    }
}