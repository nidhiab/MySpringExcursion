package com.nb.config;


import com.nb.beans.ConditionalEx;
import com.nb.beans.ProfileProdBeanEx;
import com.nb.beans.conditions.IsDevProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.nb.dao")
@ImportResource("classpath:/META-INF.spring/aggregator.xml")
public class RootConfig {
    Logger logger = LoggerFactory.getLogger(RootConfig.class);
    @Bean
    public DataSource dataSource() {
        logger.info("RootConfig::dataSource()");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spitter");
        ds.setUsername("root");
        ds.setPassword("jbmysql747#");
        return ds;
    }
    @Bean
    public MailSender mailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("127.0.0.1");
        mailSender.setPort(25);
        return mailSender;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {

        logger.info("RootConfig::jdbcTemplate()");
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        logger.info("RootConfig::entityManagerFactory()");
        LocalContainerEntityManagerFactoryBean emfb =
                new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("com.nb.beans");
        return emfb;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        logger.info("RootConfig::jpaVendorAdapter()");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        logger.info("RootConfig::transactionManager()");
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {

        logger.info("RootConfig::namedParameterJdbcTemplate()");
        return new NamedParameterJdbcTemplate(dataSource);
    }
    @Autowired
    Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){

        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("application.properties"));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;

    }
    @Bean
    @Profile("prod")
    public ProfileProdBeanEx prodBean(){
        return new ProfileProdBeanEx();
    }

    @Bean
    @Conditional(IsDevProfile.class)
    public ConditionalEx conditionalEx() {
        String activeProfile = env.getProperty("my.property.first");
        String[] requiredProp = env.getActiveProfiles();
        String[] defaultProp = env.getDefaultProfiles();
        System.out.println("property value::"+activeProfile);
        System.out.println("active profiles::"+ Arrays.toString(requiredProp));
        System.out.println("default profiles::"+Arrays.toString(defaultProp));
        return new ConditionalEx();
    }
}
