package com.github.ipwt22.tum4world.filters.pubblico;

import com.github.ipwt22.tum4world.helpers.ContatoreHelper;
import com.github.ipwt22.tum4world.helpers.DatabaseHelper;
import com.github.ipwt22.tum4world.models.Contatore;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CounterFilter implements Filter {
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String percorso = ((HttpServletRequest) request).getRequestURI();
        Contatore counter = ContatoreHelper.fromPercorso(DatabaseHelper.getConnection(),percorso);
        if (counter == null) {
            counter = new Contatore();
            counter.setPercorso(percorso);
        }
        counter.setVisite(counter.getVisite() + 1);
        ContatoreHelper.save(DatabaseHelper.getConnection(), counter);
        
        chain.doFilter(request, response);
    }
}
