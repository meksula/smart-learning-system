package org.smartlearning.repositories.interfaces;

import org.smartlearning.core.content.Notes;

import java.util.ArrayList;

public interface NotesRepository {
    ArrayList<Notes> fetchListOfNotesByUserId(long userId);

    void saveNote(Notes notes);
}
