package com.guendouz.people.model;

/**
 * Created by Guendouz on 22/11/2016.
 */

public class Name {

    private String title;
    private String first;
    private String last;

    public Name() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return Character.toString(title.charAt(0))
                .toUpperCase() + title.substring(1) + " " + first + " " + last;
    }
}
