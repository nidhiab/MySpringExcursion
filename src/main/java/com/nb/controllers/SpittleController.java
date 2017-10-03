package com.nb.controllers;

import com.nb.beans.Spittle;
import com.nb.messaging.MyMessageSender;

import com.nb.services.interfaces.AlertService;
import com.nb.services.interfaces.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    @Autowired
    private SpittleService spittleService;

   /* @Autowired
    private AlertService alertService;*/

    @RequestMapping(value = "/{spitterId}/{username}", method = RequestMethod.GET)
    public String spittles(@PathVariable Long spitterId, @PathVariable String username, Model model) {
        model.addAttribute("spittleList", spittleService.findBySpitterId(spitterId));
        model.addAttribute("username", username);
        model.addAttribute("spitterid", spitterId);
        return "spittles";
    }
    @RequestMapping(value = "/new/{spitterId}/{username}", method = RequestMethod.GET)
    public String showSpittleForm(@PathVariable Long spitterId, @PathVariable String username, Model model) {
        model.addAttribute(new Spittle());
        model.addAttribute("username", username);
        model.addAttribute("spitterid", spitterId);
        return "spittle";
    }

    @RequestMapping(value = "/new/{spitterId}/{username}", method = RequestMethod.POST)
    public String createSpittle(@PathVariable Long spitterId, @PathVariable String username, Spittle spittle, Model model) {
        spittleService.addSpittle(spittle);
        model.addAttribute("spittleList", spittleService.findBySpitterId(spitterId));
        model.addAttribute("username", username);
        model.addAttribute("spitterid", spitterId);
       /* try {
            alertService.sendSpittleAlert(spittle);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return "spittles";
    }
}
