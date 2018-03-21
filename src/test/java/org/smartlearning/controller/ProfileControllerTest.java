package org.smartlearning.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.util.NestedServletException;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author Karol Meksuła
 * 19-03-2018
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class ProfileControllerTest {
    private final Logger logger = LogManager.getLogger(ProfileControllerTest.class);

    @Autowired
    private ProfileController profileController;

    @Test
    public void prerequisitiesTest() {
        assertNotNull(profileController);
    }

    @Test(expected = NestedServletException.class)
    public void shouldReturnExpectedViewName() throws Exception {
        MockMvc mockMvc = standaloneSetup(profileController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/profile.html"))
                .build();

        mockMvc.perform(get("/profile"))
                .andExpect(model().attributeExists("username"))
                .andExpect(view().name("redirect:/profile/{username}"));
    }

    @Test
    public void shouldDirectToProfile() throws Exception {
        MockMvc mockMvc = standaloneSetup(profileController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/profile.html"))
                .build();

        mockMvc.perform(get("/profile/{username}", "systemAdmin"))
                .andExpect(model().attributeExists("systemUser"))
                .andExpect(model().attributeExists("meta"))
                .andExpect(model().attributeExists("norm"))
                .andExpect(view().name("profile"));
    }

}