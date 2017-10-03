package com.nb.messaging;

import com.nb.config.MessagingConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MyMessageListener {
    Logger logger = LoggerFactory.getLogger(MyMessageListener.class);
    @JmsListener(destination = "spittle.alert.queue", containerFactory = "org.springframework.jms.config.DefaultJmsListenerContainerFactory")
    public void onMessage(Message m) {
        logger.info("MyMessageListener...."+m);
        TextMessage message=(TextMessage)m;
        try{
            logger.info("MyMessageListener....message is:: "+message.getText());
        }catch (Exception e) {e.printStackTrace();  }
    }
}