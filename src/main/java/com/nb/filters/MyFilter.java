package com.nb.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;


public class MyFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(MyFilter.class);
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("MyFilter::init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("MyFilter::doFilter");
    }

    public void destroy() {
        logger.info("MyFilter::destroy");
    }
}
