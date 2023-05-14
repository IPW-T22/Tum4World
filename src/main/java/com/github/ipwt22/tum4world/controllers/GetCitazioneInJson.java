package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.Citazione;
import com.github.ipwt22.tum4world.models.DatabaseManager;
import com.github.ipwt22.tum4world.models.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getcitazioneinjson", value = "/getcitazioneinjson")
public class GetCitazioneInJson extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DatabaseManager databaseManager = new DatabaseManager();
        Citazione citazione = databaseManager.getRandomCitazione();
        String jsonObject = "{\"citazione\": \"" + citazione.getCitazione() + "\"}";

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try(PrintWriter out = response.getWriter()){
            out.print(jsonObject);
            out.flush();
        }
    }
}
