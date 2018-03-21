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
public class HistoryControllerTest {

    @Autowired
    private HistoryController historyController;

    @Test
    public void shouldCorrectlyDependencyInject() {
        assertNotNull(historyController);
    }

    private Principal createPrincipal() {
        return () -> "someAccount";
    }

    @Test
    public void shouldRedirectToView() throws Exception {
        MockMvc mockMvc = standaloneSetup(historyController).build();

        mockMvc.perform(get("/history").principal(createPrincipal()))
                .andExpect(model().attributeExists("username"))
                .andExpect(view().name("redirect:/history/{username}"));
    }

    @Test
    public void shouldPresentCorrectlyView() throws Exception {
        MockMvc mockMvc = standaloneSetup(historyController).build();

        Principal principal = createPrincipal();
        String username = principal.getName();

        mockMvc.perform(get("/history/{username}", username).principal(createPrincipal()))
                .andExpect(view().name("history"));
    }
}