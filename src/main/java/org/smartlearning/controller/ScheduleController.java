package org.smartlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/scheduler")
public class ScheduleController {

    @GetMapping
    public String stats(Model model, HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getUserPrincipal().getName();
        model.addAttribute("username", username);
        return "redirect:/scheduler/{username}";
    }

    @GetMapping("/{username}")
    public String statsView(@PathVariable("username")String username) {
        return "scheduler";
    }
}
