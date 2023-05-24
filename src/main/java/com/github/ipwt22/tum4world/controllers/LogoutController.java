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
            HttpSession session = request.getSession(false);
            String token = request.getParameter("token");
            String username = token.substring(0, token.indexOf(":"));

            UtenteHelper.deleteTokenOfUsername(DatabaseHelper.getConnection(), username, token);
            if (session!=null)
                session.invalidate();
        } catch (Exception ignored) {}
        response.sendRedirect("homepage?token");
    }
}