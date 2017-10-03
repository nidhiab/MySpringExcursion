package com.nb.controllers;

import com.nb.beans.AnnotationEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profileD")
@Profile("dev")
public class HelloController {
    public HelloController() {
        System.out.println("HelloController...");
    }
    @Autowired
    AnnotationEx ex;

    @RequestMapping(method = RequestMethod.GET)public String printHello(ModelMap model) {
        model.addAttribute("message", ex.getMessage());
        return "index";
    }
}
