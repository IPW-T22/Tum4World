package com.github.ipwt22.tum4world.controllers;

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
            Utente user = DB.getUserFromToken(request.getParameter("token"));
            /*user.logout(request);*/
        } catch (Exception ignored) {}
        response.sendRedirect("homepage?token");
    }
}