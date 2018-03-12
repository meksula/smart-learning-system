package org.smartlearning.core.content;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

public class Notes {
    private long noteId;
    private long userId;
    private String text;
    private String dateAndTime;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public long getNoteId() {
        return noteId;
    }
}
