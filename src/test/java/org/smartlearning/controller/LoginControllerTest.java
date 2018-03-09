package org.smartlearning.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class LoginControllerTest {
    private LoginController loginController;

    @Before
    public void setUp() {
        loginController = new LoginController();
    }

    @Test
    public void shouldReturnExpectedViewName() throws Exception {
        MockMvc mockMvc = standaloneSetup(loginController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/login.html")).build();
        mockMvc.perform(get("/login")).andExpect(view().name("login"));
    }
}