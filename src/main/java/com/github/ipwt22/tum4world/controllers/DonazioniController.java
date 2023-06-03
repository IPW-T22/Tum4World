package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.DonazioneHelper;
import com.github.ipwt22.tum4world.models.DB;
import com.github.ipwt22.tum4world.models.Donazione;
import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@WebServlet(name = "donazioni", value = "/donazioni")
public class DonazioniController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Utente utente = (Utente) request.getAttribute("utente");
        if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE) {
            int anno = new Date().getYear();
            int[] donazioni = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            DonazioneHelper.all(DatabaseHelper.getConnection())
                    .stream()
                    .filter((donazione -> donazione.getData().getYear() == anno))
                    .forEach(donazione -> {
                        int mese = donazione.getData().getMonth();
                        donazioni[mese] += donazione.getImporto();
                    });

            try (PrintWriter out = response.getWriter()) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(Donazione.GSON.toJson(donazioni));
                out.flush();
            }
        } else
            response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente utente = (Utente) request.getAttribute("utente");
        if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE || utente.getRuolo() == Utente.Ruolo.ADERENTE) {
            double amount = Double.parseDouble(request.getParameter("euro"));
            DonazioneHelper.aggiungiDonazione(DatabaseHelper.getConnection(), utente, amount);
        }
    }
}