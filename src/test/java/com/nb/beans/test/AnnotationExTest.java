package com.nb.beans.test;

import com.nb.beans.AnnotationEx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/META-INF.spring/aggregator.xml")
//@ActiveProfiles({"dev","prod","test"})
@WebAppConfiguration
public class AnnotationExTest {
    Logger logger = LoggerFactory.getLogger(AnnotationExTest.class);

    @Inject
    AnnotationEx ex;
    /*@Inject
    ProfileDevBeanEx devBeanEx;
    @Inject
    ProfileProdBeanEx prodBeanEx;*/
    /*

    @Inject
    ProfileProdBeanEx prodBeanEx;*/
    @Test
    public void testBean(){
        logger.info("testBean.......my log");

        /*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "aggregator.xml");
        ConfigurableEnvironment env = ctx.getEnvironment();
        env.setActiveProfiles("test");
        ctx.refresh();*/
        //assertNotNull(devBeanEx);
        //assertNotNull(devBeanEx);
        //ex.printIt();

    }
}
