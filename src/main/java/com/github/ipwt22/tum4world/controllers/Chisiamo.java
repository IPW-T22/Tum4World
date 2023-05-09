package com.github.ipwt22.tum4world.controllers;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "chisiamo", value = "/chisiamo")
public class Chisiamo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/chisiamo.jsp").forward(request, response);
    }
}