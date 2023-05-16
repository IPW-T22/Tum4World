package com.github.ipwt22.tum4world.filters.pubblico;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        String referer = hsr.getHeader("referer"); //URL dell'intera pagina
        String token = servletRequest.getParameter("token"); //token passato come parametro
        if (token == null && referer != null) { //non ha il token e l'url non è vuoto
            String query = URI.create(referer).getQuery(); //stringa che contiene tutti i parametri specificati dopo '?' e separati da '&' della richiesta precedente
            if (query != null) {
                String[] params = query.split("&"); //separo i singoli parametri
                for (String param : params) {
                    String[] pair = param.split("="); //separo le singole coppie di ogni parametro
                    if (pair[0].equals("token") && pair.length > 1) { //se il parametro è il token
                        String old_token = pair[1]; //memorizzo il suo valore

                        String queryString = hsr.getQueryString();
                        if (queryString == null)
                            queryString = "";
                        else
                            queryString = queryString + "&";

                        String redirectUrl = hsr.getRequestURI() + "?" + queryString + "token=" + old_token;
                        ((HttpServletResponse) servletResponse).sendRedirect(redirectUrl); //costruisco l'url corretto della prossima pagina che dovrò visitare e la visito
                        return;
                    }
                }

            }
        }
        filterChain.doFilter(servletRequest, servletResponse); //proseguo alla risorsa/pagina
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void destroy() {
    }
}
