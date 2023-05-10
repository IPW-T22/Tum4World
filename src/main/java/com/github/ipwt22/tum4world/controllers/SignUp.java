package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.UserManager;
import com.github.ipwt22.tum4world.models.Utente;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "signup", value = "/signup")
public class SignUp extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/signup.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        Date dataDiNascita = null;
        try {
            dataDiNascita = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("data_nascita"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Utente.Ruolo ruolo = Utente.Ruolo.SIMPATIZZANTE;
        if(request.getParameter("tipo_registrazione").equals("ADERENTE"))
            ruolo = Utente.Ruolo.ADERENTE;
        String username = request.getParameter("username");
        String hashPassword = request.getParameter("password");

        UserManager userManager = new UserManager(username);
        if(userManager.signUp(request, nome, cognome, dataDiNascita, email, telefono, ruolo, username, hashPassword))
            request.getRequestDispatcher("/WEB-INF/jsp/pubblico/registrazioneconfermata.jsp").forward(request, response);
        else
            response.sendRedirect("signup?error=true");
    }
}