package com.github.ipwt22.tum4world.filters.pubblico;

import com.github.ipwt22.tum4world.models.Contatori;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CounterFilter implements Filter {
    private FilterConfig config;
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    public void destroy() {
        config = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        assert config != null;
        ServletContext context = config.getServletContext();
        Contatori counter = (Contatori) context.getAttribute("contatori");
        if (counter == null) {
            counter = new Contatori();
            context.setAttribute("contatori", counter);
        }
        counter.incrementa(((HttpServletRequest) request).getRequestURI());

        chain.doFilter(request, response);
    }
}
