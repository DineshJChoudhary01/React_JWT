package com.jwt.calculator;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "allowedOrigins", value = "*"),
                @WebInitParam(name = "allowedMethods", value = "GET, POST, PUT, DELETE, OPTIONS"),
                @WebInitParam(name = "allowedHeaders", value = "*")
        }
)
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // Add the required CORS headers to allow requests from allowed origins, methods, and headers
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");

        // Continue the request processing
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
