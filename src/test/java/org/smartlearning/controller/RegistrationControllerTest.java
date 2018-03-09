package org.smartlearning.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.core.security.RegistrationProcess;
import org.smartlearning.core.user.SystemUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RegistrationControllerTest {
    private RegistrationController registrationController;
    private RegistrationProcess registrationProcess = mock(RegistrationProcess.class);

    @Before
    public void setUp() {
        registrationController = new RegistrationController();
        registrationController.setRegistrationProcess(registrationProcess);
    }

    @Test
    public void containerShouldInjectObjectsCorrectly() {
        assertNotNull(registrationController);
        assertNotNull(registrationController.getRegistrationProcess());
    }

    @Test
    public void shoudReturnExpectedViewName() throws Exception {
        MockMvc mockMvc = standaloneSetup(registrationController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/registration.html")).build();
        mockMvc.perform(get("/registration"))
                .andExpect(model().attributeExists("systemUserForm"))
                .andExpect(view().name("registration"));

    }

    @Test
    public void shouldRedirectToSetViewNamedVerificationSuccessful() throws Exception {
        MockMvc mockMvc = standaloneSetup(registrationController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/registration.html")).build();
        mockMvc.perform(post("/registration"))
                .andExpect(model().attributeExists("systemUserForm"))
                .andExpect(model().attributeExists("decission"))
                .andExpect(view().name("verification"));

    }

}