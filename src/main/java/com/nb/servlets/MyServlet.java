package com.nb.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(MyServlet.class);
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("MyServlet::service");
        super.service(req, resp);
    }
    public MyServlet() {
        super();
        logger.info("MyServlet::constructor");
    }
}
