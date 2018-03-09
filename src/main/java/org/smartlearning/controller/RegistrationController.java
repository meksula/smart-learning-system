package org.smartlearning.controller;

import org.smartlearning.core.security.RegistrationProcess;
import org.smartlearning.core.user.SystemUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private RegistrationProcess registrationProcess;

    @Autowired
    public void setRegistrationProcess(RegistrationProcess registrationProcess) {
        this.registrationProcess = registrationProcess;
    }

    public RegistrationProcess getRegistrationProcess() {
        return registrationProcess;
    }

    @GetMapping
    public String registration(Model model) {
        model.addAttribute(new SystemUserForm());
        return "registration";
    }

    @PostMapping
    public String postRegistrationForm(@Valid SystemUserForm systemUserForm, Model model) {
        boolean decission = registrationProcess.verify(systemUserForm);
        model.addAttribute("username", systemUserForm.getUsername());
        model.addAttribute("decission", decission);
        return "verification";
    }

}
