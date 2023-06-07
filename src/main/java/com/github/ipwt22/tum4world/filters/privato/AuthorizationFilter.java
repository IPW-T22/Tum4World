package com.github.ipwt22.tum4world.filters.privato;

import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.UtenteHelper;
import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try{

            Utente utente = (Utente) request.getAttribute("utente");
            if(utente == null) {
                throw new Exception("Utente non trovato");
            }
            System.out.println("Utente: " + utente.getUsername());
            System.out.println(utente.getUsername());
            request.setAttribute("utente", utente);
            chain.doFilter(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("TEST");
            ((HttpServletResponse)response).sendRedirect("login?token");
        }
    }
}