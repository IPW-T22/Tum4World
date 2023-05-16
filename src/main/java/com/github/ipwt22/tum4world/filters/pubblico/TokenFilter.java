package com.github.ipwt22.tum4world.filters.pubblico;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        String referer = hsr.getHeader("referer"); //URL dell'intera pagina
        String query;

        if (hsr.getMethod().equalsIgnoreCase("GET") && servletRequest.getParameter("token")==null && referer!=null){ //se la richiesta fatta è una GET e non ha il token e l'url non è vuoto
            query = URI.create(referer).getQuery(); //stringa che contiene tutti i parametri specificati dopo '?' e separati da '&' della richiesta precedente
            if (query != null){
                String[] params = query.split("&"); //separo i singoli parametri
                for (String param : params) {
                    String[] pair = param.split("="); //separo le singole coppie di ogni parametro
                    if (pair[0].equals("token")) { //se il parametro è il token
                        String token = pair[1]; //memorizzo il suo valore

                        String queryString = hsr.getQueryString();
                        if (queryString == null)
                            queryString = "";
                        else
                            queryString = queryString + "&";
                        ((HttpServletResponse) servletResponse).sendRedirect(hsr.getRequestURI() + "?" + queryString + "token=" + token); //costruisco l'url corretto della prossima pagina che dovrò visitare e la visito
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
