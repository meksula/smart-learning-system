package org.smartlearning.controller;

import org.smartlearning.domain.content.Notes;
import org.smartlearning.repositories.interfaces.NotesRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @Author Karol Meksuła
 * 10-03-2018
 **/

@Controller
@RequestMapping("/notes")
public class NotesController {
    private NotesRepository notesRepository;
    private BasicDataHandler basicDataHandler;

    @Autowired
    public void setNotesRepository(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    @GetMapping
    public String notes(Model model, HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getUserPrincipal().getName();
        model.addAttribute("username", username);
        return "redirect:/notes/{username}";
    }

    @GetMapping("/{username}")
    public String statsView(@PathVariable("username")String username, Model model) {
        ArrayList<Notes> notes = notesRepository.fetchListOfNotesByUserId(basicDataHandler.getUserId());
        model.addAttribute("notes", notes);
        return "notes";
    }

}
