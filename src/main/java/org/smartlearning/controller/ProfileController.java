package org.smartlearning.controller;

import org.smartlearning.core.user.SystemUser;
import org.smartlearning.core.user.SystemUserMetaData;
import org.smartlearning.repositories.interfaces.SystemUserMetaDataRepository;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private SystemUserRepository systemUserRepository;
    private SystemUserMetaDataRepository metaDataRepository;
    public String username;

    @Autowired
    public void setRepository(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @ModelAttribute("username")
    public String username() {
        return username;
    }

    @GetMapping
    public String profile(Model model, HttpServletRequest httpServletRequest) {
        username = httpServletRequest.getUserPrincipal().getName();
        model.addAttribute("username", username);
        return "redirect:/profile/{username}";
    }

    @GetMapping(value = "/{username}")
    public String mainProfile(@PathVariable("username") String username, Model model) {
        SystemUser systemUser = systemUserRepository.fetchByUsername(username);
        SystemUserMetaData systemUserMetaData = metaDataRepository.fetchMetaData(systemUser.getUserId());
        model.addAttribute("systemUser", systemUser);
        model.addAttribute("meta", systemUserMetaData);
        model.addAttribute("quote", "Cytat dnia //TODO");
        model.addAttribute("norm", 56);
        return "profile";
    }

    @Autowired
    public void setMetaDataRepository(SystemUserMetaDataRepository metaDataRepository) {
        this.metaDataRepository = metaDataRepository;
    }
}
