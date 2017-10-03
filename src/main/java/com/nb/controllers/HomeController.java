package com.nb.controllers;

import com.nb.beans.XmlDeclaredBeanEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {
    public HomeController() {
        System.out.println("HomeController...");
    }
    @Autowired
    XmlDeclaredBeanEx ex;

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", ex.getMessage());
        return "index";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hello() {
        return "index";
    }
}