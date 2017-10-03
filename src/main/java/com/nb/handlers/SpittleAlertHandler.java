package com.nb.handlers;

import com.nb.beans.Spittle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Nidhia Bhasin on 15-09-2017.
 */
public class SpittleAlertHandler {
    @Autowired
    MailSender mailSender;
    Logger logger = LoggerFactory.getLogger(SpittleAlertHandler.class);
    public void handleSpittleAlert(Spittle spittle) {
        logger.info("MessageNinni: "+spittle.toString());
        //sendSimpleSpittleEmail(spittle);
        logger.info("After Mailing ");
    }
    public void sendSimpleSpittleEmail(Spittle spittle) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            String spitterName = "Spitterer..";
            message.setFrom("Papercut@user.com");
            message.setTo("Papercut@user.com");
            message.setSubject("New spittle from " + spitterName);
            message.setText(spitterName + " says: " +
                    spittle.toString());
            mailSender.send(message);
        }catch (Exception ex) {
            logger.info("Exception in sending mail: " + ex);
        }
    }
}
