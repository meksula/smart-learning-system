package org.smartlearning.repositories.implementations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.dto.Notes;
import org.smartlearning.repositories.interfaces.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NotesRepositoryImplTest {
    private final long USER_ID = 366454;
    private final String TEXT = "Some text of note...";

    @Autowired
    private NotesRepository notesRepository;

    private Notes makeNote() {
        Notes notes = new Notes();
        notes.setText(TEXT);
        notes.setUserId(USER_ID);
        return notes;
    }

    @Test
    public void repositoryShouldBeAbleToSaveNotes() {
        notesRepository.saveNote(makeNote());
        ArrayList<Notes> notes = notesRepository.fetchListOfNotesByUserId(USER_ID);
        assertEquals(TEXT, notes.get(0).getText());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void daoShouldBeAbleRemoveNote() {
        ArrayList<Notes> notes = notesRepository.fetchListOfNotesByUserId(USER_ID);
        long noteId = notes.get(0).getNoteId();
        notesRepository.deleteNote(noteId);

        notesRepository.fetchListOfNotesByUserId(USER_ID);
    }

    @Test
    public void cleanUp() {
        notesRepository.deleteNote(USER_ID);
    }
}