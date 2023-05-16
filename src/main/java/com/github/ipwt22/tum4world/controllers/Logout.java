package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.DB;
import com.github.ipwt22.tum4world.models.Utente;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "logout", value = "/logout")
public class Logout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Utente user = DB.getUserFromKey(request.getParameter("id"));
        user.logout(request);
        response.sendRedirect("homepage?token=null");
    }
}