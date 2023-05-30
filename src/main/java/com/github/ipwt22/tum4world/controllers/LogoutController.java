package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.UtenteHelper;
import com.github.ipwt22.tum4world.models.DB;
import com.github.ipwt22.tum4world.models.Utente;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "logout", value = "/logout")
public class LogoutController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String token, username;
            HttpSession session = request.getSession(false);
            if (session!=null) {
                token = (String)session.getAttribute("token");
                username = ((Utente)session.getAttribute("BeanUtente")).getUsername();
                session.invalidate();
                response.sendRedirect("homepage");
            }
            else{
                token = request.getParameter("token");
                username = token.substring(0, token.indexOf(":"));
                UtenteHelper.deleteTokenOfUsername(DatabaseHelper.getConnection(), username, token);
                response.sendRedirect("homepage?token");
            }

        } catch (Exception ignored) {}
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sessione = request.getSession(false);

        String token = null;
        if (sessione != null) token = (String)sessione.getAttribute("token");
        if (token == null) token = request.getParameter("token");

        System.out.println("Token: " + token);
        String username = UtenteHelper.deleteFromToken(DatabaseHelper.getConnection(), token);
        System.out.println("Eliminato: "+username);
        response.sendRedirect("homepage?token");

    }
}