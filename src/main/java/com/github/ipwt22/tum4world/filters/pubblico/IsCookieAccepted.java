package com.github.ipwt22.tum4world.filters.pubblico;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "IsCookieAccepted", urlPatterns = {"/"})
public class IsCookieAccepted implements Filter {
    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //preprocessing
        chain.doFilter(request, response);
        //postprocessing
    }
}
