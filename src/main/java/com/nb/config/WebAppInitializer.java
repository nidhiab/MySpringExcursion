package com.nb.config;

import com.nb.filters.MyFilter;
import com.nb.servlets.MyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebAppInitializer  implements WebApplicationInitializer {
    Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);
    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.info("WebAppInitializer::onStartup");
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("myServlet", MyServlet.class);
        servletRegistration.addMapping("/custom/**");

        FilterRegistration.Dynamic filterRegistration =
                servletContext.addFilter("myFilter", MyFilter.class);
        filterRegistration.addMappingForUrlPatterns(null, false, "/custom/*");
    }

}