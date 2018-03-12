package org.smartlearning.controller;

import org.smartlearning.core.content.Task;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/learn")
public class LearnController {
    private TasksToDoRepository tasksToDoRepository;
    private int id;
    private BasicDataHandler basicDataHandler;

    @Autowired
    public void setTasksToDoRepository(TasksToDoRepository tasksToDoRepository) {
        this.tasksToDoRepository = tasksToDoRepository;
    }

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    @ModelAttribute("id")
    public int id() {
        return id;
    }

    @GetMapping("/{id}")
    public String learn(@PathVariable("id") int id, Model model) {
        this.id = id;
        Task task = tasksToDoRepository.fetchOneTaskByTaskId(id);
        basicDataHandler.setTaskId(id);
        model.addAttribute("task", task);
        return "learn";
    }

    @PostMapping("/start")
    public String start() {
        return "redirect:/learn/{id}";
    }

    @PostMapping("/stop")
    public String stop(Model model) {
        return "redirect:/learn/{id}";
    }

}
