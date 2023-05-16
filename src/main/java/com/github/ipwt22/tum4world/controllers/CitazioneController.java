package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.models.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "citazione", value = "/citazione")
public class CitazioneController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DB databaseManager = new DB();
        com.github.ipwt22.tum4world.models.Citazione citazione = databaseManager.getRandomCitazione();
        String jsonObject = "{\"citazione\": \"" + citazione.getCitazione() + "\"}";

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try(PrintWriter out = response.getWriter()){
            out.print(jsonObject);
            out.flush();
        }
    }
}
