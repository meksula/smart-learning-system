package org.smartlearning.core.services;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

public class Quote {
    private long id;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
