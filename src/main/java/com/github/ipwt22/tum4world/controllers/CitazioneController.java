package com.github.ipwt22.tum4world.controllers;

import com.github.ipwt22.tum4world.helpers.CitazioneHelper;
import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.models.Citazione;

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
        Citazione citazione = CitazioneHelper.random(DatabaseHelper.getConnection());
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try(PrintWriter out = response.getWriter()){
            out.print(citazione.toJson());
            out.flush();
        }
        System.out.println("CITAZIONE INVOCATA");
    }
}
