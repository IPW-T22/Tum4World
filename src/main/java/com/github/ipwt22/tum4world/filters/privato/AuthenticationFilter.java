package com.github.ipwt22.tum4world.filters.privato;

import com.github.ipwt22.tum4world.controllers.UtenteController;
import com.github.ipwt22.tum4world.models.Utente;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/dashboard"})
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            HttpSession sessione = ((HttpServletRequest) request).getSession(false);
            String token = (String) sessione.getAttribute("token");
            Utente utente = UtenteController.risolvi(token);
            System.out.println(utente.getUsername());
            request.setAttribute("utente", utente);
            chain.doFilter(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/jsp/pubblico/login.jsp").forward(request, response);
        }
    }
}
