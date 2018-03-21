package org.smartlearning.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author Karol Meksuła
 * 11-03-2018
 **/


public class WelcomeControllerTest {
    private WelcomeController welcomeController;

    @Before
    public void setUp() {
        this.welcomeController = new WelcomeController();
    }

    @Test
    public void shouldGetCorrectView() throws Exception {
        MockMvc mockMvc = standaloneSetup(welcomeController).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("welcome"));
    }
}