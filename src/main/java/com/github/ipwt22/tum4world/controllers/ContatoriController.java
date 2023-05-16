package com.github.ipwt22.tum4world.controllers;

import argo.format.JsonFormatter;
import argo.format.PrettyJsonFormatter;
import argo.jdom.JsonNode;
import com.github.ipwt22.tum4world.models.Contatori;
import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import static argo.jdom.JsonNodeFactories.*;

@WebServlet(name = "contatori", value = "/contatori")
public class ContatoriController extends HttpServlet {
    private static final JsonFormatter JSON_FORMATTER = new PrettyJsonFormatter();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Utente utente = (Utente) request.getAttribute("utente");
        if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE) {
            ServletContext context = request.getServletContext();
            Contatori contatori = (Contatori) context.getAttribute("contatori");

            try (PrintWriter out = response.getWriter()) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(JSON_FORMATTER.format(contatori.toJson()));
                out.flush();
            }
        } else
            response.setStatus(403);
    }
}