package com.nb.controllers.test;


import com.nb.controllers.HomeController;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF.spring/aggregator.xml" })
@WebAppConfiguration
public class HomeControllerTest {
    Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Test
    public void testHomePage() throws Exception {
        logger.debug("testHomePage");

        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(view().name("index")).andExpect(model().attribute("message", "Hello from XmlDeclaredBeanEx"));
        //mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(view().name("index"));
    }
}
