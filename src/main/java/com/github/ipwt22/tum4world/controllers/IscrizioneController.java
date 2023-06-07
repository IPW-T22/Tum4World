package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.IscrizioneHelper;
import com.github.ipwt22.tum4world.models.Iscrizione;
import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "iscrizione", value = "/iscrizione")
public class IscrizioneController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        int attivita_id = Integer.parseInt(request.getParameter("attivita_id"));
        boolean iscritto = Boolean.parseBoolean(request.getParameter("iscrizione"));
        Utente utente = (Utente) request.getAttribute("utente");
        System.out.println("ISCRIZIONE INVOCATA: " + request.getParameter("token"));
        System.out.println("attivita_id: "+ attivita_id + " iscritto: " + iscritto);

        Iscrizione iscrizione = new Iscrizione();
        iscrizione.setAttivita_id(attivita_id);
        iscrizione.setUsername(utente.getUsername());
        System.out.println("iscrizione utente: "  + utente.getUsername());
        IscrizioneHelper.save(DatabaseHelper.getConnection(), iscrizione, iscritto);
    }
}