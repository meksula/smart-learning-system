package org.smartlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

@Controller
@RequestMapping("/history")
public class HistoryController {

    @GetMapping
    public String history(Model model, HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getUserPrincipal().getName();
        model.addAttribute("username", username);
        return "redirect:/history/{username}";
    }

    @GetMapping("/{username}")
    public String historyView(@PathVariable("username")String username) {
        return "history";
    }
}
