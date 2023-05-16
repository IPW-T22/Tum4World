package com.github.ipwt22.tum4world.filters.pubblico;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

@WebFilter(filterName = "TokenFilter", urlPatterns = {"/*"})
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getParameter("token") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpServletRequest hsr = (HttpServletRequest) servletRequest;
        String referer = hsr.getHeader("referer");
        if (referer == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String query = URI.create(referer).getQuery();
        if (query == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String[] params = query.split("&");
        for (String param : params) {
            String[] pair = param.split("=");
            if (pair[0].equals("token")) {
                String token = pair[1];
                System.out.println("Token: " + token);

                String queryString = hsr.getQueryString();
                if (queryString == null)
                    queryString = "";
                else
                    queryString = queryString + "&";

                ((HttpServletResponse) servletResponse).sendRedirect(hsr.getRequestURI() + "?" + queryString + "token=" + token);
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void destroy() {
    }
}
