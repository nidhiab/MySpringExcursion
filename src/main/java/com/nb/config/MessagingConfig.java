package com.nb.config;

import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;


import javax.sql.DataSource;

@Configuration
public class MessagingConfig {
    Logger logger = LoggerFactory.getLogger(MessagingConfig.class);

    @Bean
    public JmsTemplate jmsTemplate() {
        logger.info("MessagingConfig::jdbcTemplate()");
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestinationName("spittle.alert.queue");
        return jmsTemplate;
    }

    @Bean
    JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
        logger.info("MessagingConfig::jmsMessagingTemplate()");
        JmsMessagingTemplate messagingTemplate = new JmsMessagingTemplate(jmsTemplate);
        messagingTemplate.setDefaultDestinationName("spittle.alert.queue");
        return messagingTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        logger.info("MessagingConfig::connectionFactory()");
        return new ActiveMQConnectionFactory();
    }
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());

        return factory;
    }
}
