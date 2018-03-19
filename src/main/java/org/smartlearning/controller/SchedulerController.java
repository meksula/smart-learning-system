package org.smartlearning.controller;

import org.smartlearning.domain.content.Notes;
import org.smartlearning.domain.content.Task;
import org.smartlearning.repositories.interfaces.NotesRepository;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.smartlearning.repositories.temporary.IdHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

@Controller
@RequestMapping("/scheduler")
public class SchedulerController {
    private BasicDataHandler basicDataHandler;
    private NotesRepository notesRepository;
    private TasksToDoRepository tasksToDoRepository;
    private String username;

    @Autowired
    public void setTasksToDoRepository(TasksToDoRepository tasksToDoRepository) {
        this.tasksToDoRepository = tasksToDoRepository;
    }

    @Autowired
    public void setNotesRepository(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    @ModelAttribute("username")
    public String username() {
        return username;
    }

    @GetMapping
    public String scheduler(Model model, HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getUserPrincipal().getName();
        this.username = username;
        model.addAttribute("username", username);
        return "redirect:/scheduler/{username}";
    }

    @GetMapping("/{username}")
    public String shedulerView(@PathVariable("username")String username, Model model) {
        model.addAttribute("notes", new Notes());
        model.addAttribute("task", new Task());
        model.addAttribute("taskList",
                tasksToDoRepository.fetchTasksToDo(basicDataHandler.getUserId()));
        model.addAttribute("idHandler", new IdHandler());
        return "scheduler";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute("notes") Notes notes, String text) {
        notes.setUserId(basicDataHandler.getUserId());
        notes.setDateAndTime(LocalDate.now().toString());
        notesRepository.saveNote(notes);

        return "redirect:/scheduler/{username}";
    }

    @PostMapping("/addTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        task.setUserId(basicDataHandler.getUserId());
        task.setStartDate(LocalDate.now().toString());
        tasksToDoRepository.saveTaskToDo(task);
        return "redirect:/scheduler/{username}";
    }

    @PostMapping("/learn")
    public String doTask(@ModelAttribute("idHandler")IdHandler idHandler, Model model) {
        System.out.println(idHandler.getId());
        model.addAttribute("id", idHandler.getId());
        return "redirect:/learn/{id}";
    }
}
