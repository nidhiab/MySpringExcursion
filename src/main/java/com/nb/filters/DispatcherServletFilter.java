package com.nb.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;


public class DispatcherServletFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(DispatcherServletFilter.class);
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("DispatcherServletFilter::init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("DispatcherServletFilter::doFilter");
    }

    public void destroy() {
        logger.info("DispatcherServletFilter::destroy");
    }
}