package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.ContatoreHelper;
import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.models.Contatore;
import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "contatori", value = "/contatori")
public class ContatoriController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Utente utente = (Utente) request.getAttribute("utente");
        if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE) {
            List<Contatore> contatori = ContatoreHelper.all(DatabaseHelper.getConnection())
                    .stream()
                    .filter(contatore -> !contatore.getPercorso().matches(".*\\.[^/]*$"))
                    .peek(contatore -> {
                        String[] percorso = contatore.getPercorso().split("/");
                        String pagina = percorso[percorso.length - 1];
                        pagina = pagina.substring(0,1).toUpperCase() + pagina.substring(1);
                        contatore.setNome(pagina);
                    })
                    .collect(Collectors.toList());

            try (PrintWriter out = response.getWriter()) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(Contatore.GSON.toJson(contatori));
                out.flush();
            }
        } else
            response.setStatus(403);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente utente = (Utente) request.getAttribute("utente");
        if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE) {
            ContatoreHelper.delete(DatabaseHelper.getConnection());

            response.setStatus(200);
        } else
            response.setStatus(403);
    }
}