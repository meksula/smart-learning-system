package org.smartlearning.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.security.Principal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author Karol Meksuła
 * 21-03-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class StatisticsControllerTest {

    @Autowired
    private StatisticsController statisticsController;

    @Test
    public void prerequisities() {
        assertNotNull(statisticsController);
    }

    private Principal createPrincipal() {
        return () -> "someAccount";
    }

    @Test
    public void shouldRedirectToNextMethod() throws Exception {
        MockMvc mockMvc = standaloneSetup(statisticsController).build();

        mockMvc.perform(get("/stats").principal(createPrincipal()))
                .andExpect(model().attributeExists("username"))
                .andExpect(view().name("redirect:/stats/{username}"));
    }

    @Test
     public void shouldPresentCorrectlyView() throws Exception {
        MockMvc mockMvc = standaloneSetup(statisticsController).build();

        Principal principal = createPrincipal();

        mockMvc.perform(get("/stats/{username}", principal.getName()).principal(principal))
                .andExpect(view().name("stats"));
    }
}