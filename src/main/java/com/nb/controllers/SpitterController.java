package com.nb.controllers;


import com.nb.beans.Spitter;
import com.nb.dao.interfaces.SpittleRepository;
import com.nb.services.interfaces.SpitterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitters")
public class SpitterController {
    Logger logger = LoggerFactory.getLogger(SpitterController.class);
    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "/spitter/{username}", method = RequestMethod.GET)
    public String spitter(@PathVariable String username, Model model) {
        Spitter spitter = null;
        if (!model.containsAttribute("spitter")) {
            logger.info("Spitter not found, so getting from db");
            spitter = spitterService.findSpitterByUsername(username);
            model.addAttribute(spitter);
        } else
            logger.info("Spitter found");

        //model.addAttribute(spitterService.findSpitter(spitter.getId()));
        return "spitter";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "register";
    }

    //@RequestMapping(value = "/register", method = RequestMethod.POST)
    @PostMapping(value = "/register")
    public String processRegistration(Spitter spitter, @RequestParam("file") MultipartFile file, RedirectAttributes model, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }

        spitterService.addSpitter(spitter);
        model.addAttribute("username", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitters/spitter/{username}";// + spitter.getUsername();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spitters(Model model) {
        model.addAttribute(spitterService.findSpitters(1L, 20));
        return "spitters";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spitter_id") long spitterId,
            Model model) {
        model.addAttribute(spitterService.findSpitter(spitterId));
        return "spitter";
    }

}
