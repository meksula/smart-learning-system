package org.smartlearning.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.security.RegistrationProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author Karol Meksuła
 * 21-03-2018
 **/

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RegistrationControllerTest {
    private RegistrationProcess registrationProcess = mock(RegistrationProcess.class);

    @Autowired
    private RegistrationController registrationController;

    @Before
    public void setUp() {
        registrationController.setRegistrationProcess(registrationProcess);
    }

    @Test
    public void containerShouldInjectObjectsCorrectly() {
        assertNotNull(registrationController);
    }

    @Test
    public void shoudReturnExpectedViewName() throws Exception {
        MockMvc mockMvc = standaloneSetup(registrationController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/registration.html")).build();
        mockMvc.perform(get("/registration"))
                .andExpect(model().attributeExists("systemUserForm"))
                .andExpect(view().name("registration"));

    }

    private MultiValueMap<String, String> provideFakeForm() {
        MultiValueMap<String, String> formParam = new LinkedMultiValueMap<>();
        formParam.add("username", "KarolAdmin");
        formParam.add("password", "Password19934");
        formParam.add("name", "Karol");
        formParam.add("surname", "Karolkiewicz");
        formParam.add("bornYear", "1995");
        formParam.add("confirmPassword", "Password19934");
        formParam.add("email", "karol.kololo@gmail.com");
        return formParam;
    }

    @Test
    public void shouldRedirectToSetViewNamedVerificationSuccessful() throws Exception {
        MockMvc mockMvc = standaloneSetup(registrationController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/registration.html")).build();
        mockMvc.perform(post("/registration")
                .params(provideFakeForm()))
                .andExpect(model().attributeExists("systemUserForm"))
                .andExpect(model().attributeExists("decission"))
                .andExpect(view().name("verificationSuccessful"));

    }

}