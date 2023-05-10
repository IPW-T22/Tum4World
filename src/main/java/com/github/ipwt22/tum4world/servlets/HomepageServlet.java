package com.github.ipwt22.tum4world.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "homepageServlet", value = "/")
public class HomepageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("test");
        request.getRequestDispatcher("/WEB-INF/jsp/pubblico/homepage.jsp").forward(request, response);
    }
}