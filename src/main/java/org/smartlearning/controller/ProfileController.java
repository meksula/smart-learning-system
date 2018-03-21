package org.smartlearning.controller;

import org.smartlearning.domain.user.SystemUser;
import org.smartlearning.domain.user.extenders.SystemUserMetaData;
import org.smartlearning.repositories.interfaces.SystemUserMetaDataRepository;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private SystemUserRepository systemUserRepository;
    private SystemUserMetaDataRepository metaDataRepository;
    private String username;
    private BasicDataHandler basicDataHandler;

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    @Autowired
    public void setRepository(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Autowired
    public void setMetaDataRepository(SystemUserMetaDataRepository metaDataRepository) {
        this.metaDataRepository = metaDataRepository;
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
    public String mainProfile(@PathVariable("username") String username, Model model) throws IOException {
        SystemUser systemUser = systemUserRepository.fetchByUsername(username);
        SystemUserMetaData systemUserMetaData = metaDataRepository.fetchMetaData(systemUser.getUserId());
        basicDataHandler.setUserId(systemUser.getUserId());
        basicDataHandler.setUsername(systemUser.getUsername());
        model.addAttribute("systemUser", systemUser);
        model.addAttribute("meta", systemUserMetaData);
        //model.addAttribute("article", articleFetcher.giveMeOneArticle(systemUserMetaData));
        //model.addAttribute("quote", Quote.quoteByDay());
        model.addAttribute("norm", 56); //TODO
        return "profile";
    }

}
