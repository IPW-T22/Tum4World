package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.AttivitaHelper;
import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.IscrizioneHelper;
import com.github.ipwt22.tum4world.helpers.UtenteHelper;
import com.github.ipwt22.tum4world.models.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "dashboard", value = "/dashboard")
public class DashboardController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Utente utente = (Utente) request.getAttribute("utente");
        RequestDispatcher dispatcher = null;
        List<Iscrizione> iscrizioni = IscrizioneHelper.fromUtente(DatabaseHelper.getConnection(), utente);
        List<Attivita> attivita = AttivitaHelper.all(DatabaseHelper.getConnection());
        for(Attivita a : attivita)
            if(iscrizioni.stream().anyMatch(i -> i.getAttivita_id() == a.getId()))
                a.setIscritto(true);
        if (utente.getRuolo() == Utente.Ruolo.SIMPATIZZANTE) {
            request.setAttribute("attivita", new Attivitas(attivita));
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privato/simpatizzante.jsp");
        }else if (utente.getRuolo() == Utente.Ruolo.ADERENTE) {
            request.setAttribute("attivita", new Attivitas(attivita));
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privato/aderente.jsp");
        }else if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE) {
            List<Utente> utenti = UtenteHelper.all(DatabaseHelper.getConnection());
            request.setAttribute("utenti", new Utenti(utenti));
            List<Utente> simpatizzanti = utenti.stream()
                    .filter(u -> u.getRuolo() == Utente.Ruolo.SIMPATIZZANTE)
                    .collect(Collectors.toList());
            request.setAttribute("simpatizzanti", new Utenti(simpatizzanti));
            List<Utente> aderenti = utenti.stream()
                    .filter(u -> u.getRuolo() == Utente.Ruolo.ADERENTE)
                    .collect(Collectors.toList());
            request.setAttribute("aderenti", new Utenti(aderenti));
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privato/amministratore.jsp");
        }
        assert dispatcher != null;

        dispatcher.forward(request, response);
    }
}