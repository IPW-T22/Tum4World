package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.UtenteHelper;
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
        String password = request.getParameter("password");
        HttpSession session = null;
        String cookieAcceptedVal = UtenteHelper.get_value_from_cookie("cookieAccepted", request);
        String token;

        Utente user = UtenteHelper.fromUsername(DatabaseHelper.getConnection(), username);
        if(user==null) {
            user = new Utente();
            user.setUser(nome, cognome, email, telefono, username, password, dataDiNascita, ruolo);
            token = UtenteHelper.generateUniqueToken(username);
            UtenteHelper.registerUser(DatabaseHelper.getConnection(), user);
            UtenteHelper.setKeyOf(DatabaseHelper.getConnection(), username, token);
            if(cookieAcceptedVal!=null && cookieAcceptedVal.equals("true")) {
                session = request.getSession();
                session.setAttribute("BeanUtente", user);
                session.setAttribute("token", token);
                response.sendRedirect("registrazioneconfermata");
            }
            else
                response.sendRedirect("registrazioneconfermata?token="+token);
        }
        else
            response.sendRedirect("signup?error=true");
    }
}