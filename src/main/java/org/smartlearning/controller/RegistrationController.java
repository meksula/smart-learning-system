package org.smartlearning.controller;

import org.smartlearning.core.security.RegistrationProcess;
import org.smartlearning.core.user.SystemUserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private RegistrationProcess registrationProcess;

    public RegistrationController(RegistrationProcess registrationProcess) {
        this.registrationProcess = registrationProcess;
    }

    @GetMapping
    public String registration(Model model) {
        model.addAttribute(new SystemUserForm());
        return "registration";
    }

    @PostMapping
    public String postRegistrationForm(SystemUserForm systemUserForm, Model model) {
        boolean decission = registrationProcess.verifyIfUsernameIsNotUsed(systemUserForm);
        model.addAttribute(decission);
        return "verification";
    }
}
