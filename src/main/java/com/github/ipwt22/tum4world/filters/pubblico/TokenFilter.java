package com.github.ipwt22.tum4world.filters.pubblico;

import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.helpers.UtenteHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        String referer = hsr.getHeader("referer"); //URL dell'intera pagina da cui vengo
        String token = servletRequest.getParameter("token"); //token passato come parametro

        if (token == null && referer != null) { //non ha il token e l'url non è vuoto (all'inizio è vuoto l'url)
            String query = URI.create(referer).getQuery(); //stringa che contiene tutti i parametri specificati dopo '?' e separati da '&' della richiesta precedente
            if (query != null) {
                token = getToken(query); //dal queryURL vediamo se c'è il token e lo prendiamo
                if(UtenteHelper.fromToken(DatabaseHelper.getConnection(), token)!=null) { //se il token è valido
                    String queryURLDest = hsr.getQueryString(); //ottengo il queryUrl del url di destinazione
                    String redirectUrl;
                    if (queryURLDest == null)
                        queryURLDest = "";
                    else
                        queryURLDest = queryURLDest + "&";
                    redirectUrl = hsr.getRequestURI() + "?" + queryURLDest + "token=" + token ;
                    ((HttpServletResponse) servletResponse).sendRedirect(redirectUrl); //costruisco l'url corretto della prossima pagina che dovrò visitare e la visito
                    return;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse); //proseguo alla risorsa/pagina
    }

    String getToken(String queryURL){
        String[] params = queryURL.split("&"); //separo i singoli parametri
        for (String param : params) {
            String[] pair = param.split("="); //separo le singole coppie di ogni parametro
            if (pair[0].equals("token") && pair.length > 1) { //se il parametro è il token
                return pair[1]; //memorizzo il suo valore
            }
        }
        return null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void destroy() {
    }
}
