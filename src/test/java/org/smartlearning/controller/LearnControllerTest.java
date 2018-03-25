package org.smartlearning.controller;

import org.aspectj.lang.annotation.Aspect;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author
 * Karol Meksuła
 * 21-03-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class LearnControllerTest {

    @Autowired
    private LearnController learnController;

    @Autowired
    private BasicDataHandler basicDataHandler;

    @Before
    public void setUp() {
        basicDataHandler.setUserId(1);
    }

    @Test
    public void shouldHaveAllAtributes() throws Exception {
        MockMvc mockMvc = standaloneSetup(learnController).build();

        mockMvc.perform(post("/learn/stop"))
                .andExpect(view().name("redirect:/learn/{id}"));
    }
}