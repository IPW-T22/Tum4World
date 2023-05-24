package com.github.ipwt22.tum4world.controllers;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "attivita", value = "/attivita")
public class AttivitaController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nomeAttivita = request.getParameter("nomeAttivita");
        if(request.getParameter("nomeAttivita")!=null && !nomeAttivita.contains("/"))
            request.getRequestDispatcher("/WEB-INF/jsp/pubblico/attivita/" + request.getParameter("nomeAttivita")).forward(request, response);
        else
            request.getRequestDispatcher("/WEB-INF/jsp/pubblico/paginaattivita.jsp").forward(request, response);
    }
}