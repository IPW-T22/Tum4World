package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "contatti", value = "/contatti")
public class ContattiController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/contatti.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String motivoContatto = request.getParameter("motivo_contatto");
        String dettagliRichiesta = request.getParameter("dettagli_richiesta");

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmailContattaci(nome, cognome, email, motivoContatto, dettagliRichiesta);

        response.sendRedirect("invioconfermato");
    }
}