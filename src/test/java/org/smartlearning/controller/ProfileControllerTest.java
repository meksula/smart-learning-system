package org.smartlearning.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author Karol Meksuła
 * 05-03-2018
 **/

public class ProfileControllerTest {
    private ProfileController profileController;

    @Before
    public void setUp() {
        this.profileController = new ProfileController();
    }

    @Test
    public void shouldReturnExpectedViewName() throws Exception {
        MockMvc mockMvc = standaloneSetup(profileController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/profile.html")).build();

        mockMvc.perform(get("/profile"))
                .andExpect(view().name("profile"))
                .andExpect(model().attributeExists("systemUser"));
    }
}