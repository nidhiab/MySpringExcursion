package com.nb.services;

import com.nb.beans.Spittle;
import com.nb.services.interfaces.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class AlertServiceImpl implements AlertService {
    private JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }
    public void sendSpittleAlert(final Spittle spittle) {

        jmsOperations.send(
                new MessageCreator() {
                    public Message createMessage(Session session)
                            throws JMSException {
                        return session.createObjectMessage(spittle);
                    }
                }
        );
    }


}