package com.nb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    Logger logger = LoggerFactory.getLogger(MvcInitializer.class);
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class, SecurityConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        logger.info("MvcInitializer::customizeRegistration");
        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp/spittr/uploads"));
        logger.info("MvcInitializer::after customizeRegistration");
    }


}
