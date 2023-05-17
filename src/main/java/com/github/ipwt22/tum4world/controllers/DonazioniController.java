package com.github.ipwt22.tum4world.controllers;

import argo.format.JsonFormatter;
import argo.format.PrettyJsonFormatter;
import argo.jdom.JsonNode;
import argo.jdom.JsonNodeFactories;
import com.github.ipwt22.tum4world.models.Contatori;
import com.github.ipwt22.tum4world.models.DB;
import com.github.ipwt22.tum4world.models.Donazione;
import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import static argo.jdom.JsonNodeFactories.array;
import static argo.jdom.JsonNodeFactories.number;

@WebServlet(name = "donazioni", value = "/donazioni")
public class DonazioniController extends HttpServlet {
    private static final JsonFormatter JSON_FORMATTER = new PrettyJsonFormatter();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Utente utente = (Utente) request.getAttribute("utente");
        if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE) {
            int anno = new Date().getYear();
            int[] donazioni = {0,0,0,0,0,0,0,0,0,0,0,0};
            DB.getDonazioni()
                    .stream()
                    .filter((donazione -> donazione.getData().getYear() == anno))
                    .forEach(donazione -> {
                        int mese = donazione.getData().getMonth();
                        donazioni[mese] += donazione.getAmount();
                    });

            JsonNode json = array(Arrays.stream(donazioni)
                    .mapToObj(JsonNodeFactories::number)
                    .collect(Collectors.toList())
            );

            try (PrintWriter out = response.getWriter()) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(JSON_FORMATTER.format(json));
                out.flush();
            }
        } else
            response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente utente = (Utente) request.getAttribute("utente");
        if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE || utente.getRuolo() == Utente.Ruolo.ADERENTE) {
            int amount = Integer.parseInt(request.getParameter("amount"));
            DB.addDonation(utente, amount);
        }
    }
}