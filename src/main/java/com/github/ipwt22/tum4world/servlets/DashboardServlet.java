package com.github.ipwt22.tum4world.servlets;

import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Utente utente = (Utente) request.getAttribute("utente");
        RequestDispatcher dispatcher = null;
        if (utente.getRuolo() == Utente.Ruolo.SIMPATIZZANTE)
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privato/simpatizzante.jsp");
        else if (utente.getRuolo() == Utente.Ruolo.ADERENTE)
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privato/aderente.jsp");
        else if (utente.getRuolo() == Utente.Ruolo.AMMINISTRATORE)
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privato/amministratore.jsp");

        assert dispatcher != null;

        dispatcher.forward(request, response);
    }
}