package org.smartlearning.repositories.implementations;

import org.smartlearning.domain.content.Notes;
import org.smartlearning.repositories.interfaces.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

@Repository
public class NotesRepositoryImpl implements NotesRepository {
    private JdbcOperations jdbcOperations;
    private final String FETCH_QUERY = "SELECT * FROM notes WHERE userId=?";
    private final String SAVE_QUERY = "INSERT INTO notes (userId, text, dateAndTime) values(?,?,?)";

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public ArrayList<Notes> fetchListOfNotesByUserId(long userId) {
        ArrayList<Notes> notesList = new ArrayList<>();
        jdbcOperations.queryForObject(FETCH_QUERY, (rs, row) -> {
            do {
                Notes notes = new Notes();
                notes.setNoteId(rs.getInt("noteId"));
                notes.setUserId(rs.getInt("userId"));
                notes.setText(rs.getString("text"));
                notes.setDateAndTime(rs.getString("dateAndTime"));
                notesList.add(notes);
            } while (rs.next());
            return notesList;
        }, userId);

        return notesList;
    }

    @Override
    public void saveNote(Notes notes) {
        jdbcOperations.update(SAVE_QUERY, notes.getUserId(),
                notes.getText(), notes.getDateAndTime());
    }
}
