package org.smartlearning.controller;

import org.smartlearning.domain.statistics.StatisticsProcessor;
import org.smartlearning.domain.statistics.StatsRepresentation;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/stats")
public class StatisticsController {

    private StatisticsProcessor statisticsProcessor;
    private BasicDataHandler basicDataHandler;

    @Autowired
    public void setStatisticsProcessor(StatisticsProcessor statisticsProcessor) {
        this.statisticsProcessor = statisticsProcessor;
    }

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    @GetMapping
    public String stats(Model model, HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getUserPrincipal().getName();
        model.addAttribute("username", username);
        return "redirect:/stats/{username}";
    }

    @GetMapping("/{username}")
    public String statsView(@PathVariable("username")String username, Model model) {
        long userId = basicDataHandler.getUserId();
        StatsRepresentation stats = statisticsProcessor.retriveStatistics(userId);
        model.addAttribute("stats", stats);
        return "stats";
    }
}
