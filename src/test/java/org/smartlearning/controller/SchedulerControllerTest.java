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
public class SchedulerControllerTest {

    @Autowired
    private SchedulerController schedulerController;

    @Test
    public void prerequisities() {
        assertNotNull(schedulerController);
    }

    private Principal createPrincipal() {
        return () -> "someAccount";
    }

    @Test
    public void shouldRedirectToNextMethod() throws Exception {
        MockMvc mockMvc = standaloneSetup(schedulerController).build();

        mockMvc.perform(get("/scheduler").principal(createPrincipal()))
                .andExpect(model().attributeExists("username"))
                .andExpect(view().name("redirect:/scheduler/{username}"));
    }

    @Test
    public void shouldPresentCorrectlyView() throws Exception {
        MockMvc mockMvc = standaloneSetup(schedulerController).build();

        Principal principal = createPrincipal();

        mockMvc.perform(get("/scheduler/{username}", principal.getName()).principal(principal))
                .andExpect(view().name("scheduler"));
    }
}