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
            String id = sessione != null ?
                    sessione.getAttribute("id").toString():
                    request.getAttribute("id").toString();
            System.out.println("ID: " + id);
            Utente utente = UtenteController.risolvi(id);
            System.out.println(utente.getUsername());
            request.setAttribute("utente", utente);
            chain.doFilter(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/jsp/pubblico/login.jsp").forward(request, response);
        }
    }
}
