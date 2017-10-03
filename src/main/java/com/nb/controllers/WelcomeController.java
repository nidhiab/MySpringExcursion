package com.nb.controllers;

import com.nb.beans.AnnotationEx;
import com.nb.beans.XmlDeclaredBeanEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profileP")
@Profile("prod")
public class WelcomeController {
    public WelcomeController() {
        System.out.println("WelcomeController...");
    }
    @Autowired
    XmlDeclaredBeanEx ex;

    @RequestMapping(method = RequestMethod.GET)public String printHello(ModelMap model) {
        model.addAttribute("message", ex.getMessage());
        return "index";
    }
}