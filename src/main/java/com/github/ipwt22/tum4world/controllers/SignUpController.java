package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.Utente;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "signup", value = "/signup")
public class SignUpController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/signup.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String dataDiNascita = request.getParameter("data_nascita");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Utente.Ruolo ruolo = Utente.Ruolo.SIMPATIZZANTE;
        if(request.getParameter("tipo_registrazione").equals("ADERENTE"))
            ruolo = Utente.Ruolo.ADERENTE;
        String username = request.getParameter("username");
        String hashPassword = request.getParameter("password");

        Utente user = new Utente();
        if(false /*user.signUp(request, nome, cognome, email, telefono, username, hashPassword, dataDiNascita, ruolo.ordinal())*/)
            response.sendRedirect("registrazioneconfermata?token=") /*+user.getToken())*/;
        else
            response.sendRedirect("signup?error=true");
    }
}