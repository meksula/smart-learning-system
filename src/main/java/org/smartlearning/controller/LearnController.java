package org.smartlearning.controller;

import org.smartlearning.domain.dto.Task;
import org.smartlearning.domain.content.time.TimeFormatter;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 21-03-2018
 * */

@Controller
@RequestMapping("/learn")
public class LearnController {
    private TasksToDoRepository tasksToDoRepository;
    private BasicDataHandler basicDataHandler;

    @Autowired
    public void setTasksToDoRepository(TasksToDoRepository tasksToDoRepository) {
        this.tasksToDoRepository = tasksToDoRepository;
    }

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    private int id;

    @ModelAttribute("id")
    public int id() {
        return id;
    }

    private long spendTimeAtLearn = 0;

    @GetMapping("/{id}")
    public String learn(@PathVariable("id") int id, Model model) {
        this.id = id;

        Task task = tasksToDoRepository.fetchOneTaskByTaskId(id);
        basicDataHandler.setTaskId(id);
        model.addAttribute("task", task);

        if (spendTimeAtLearn != 0)
            model.addAttribute("time",
                    TimeFormatter.getInstance().formatTimeFromSeconds(spendTimeAtLearn));

        return "learn";
    }

    @PostMapping("/start")
    public String start() {
        return "redirect:/learn/{id}";
    }

    @PostMapping("/stop")
    public String stop(Model model) {
        spendTimeAtLearn = basicDataHandler.getTemporaryLearningTime();
        return "redirect:/learn/{id}";
    }

}
