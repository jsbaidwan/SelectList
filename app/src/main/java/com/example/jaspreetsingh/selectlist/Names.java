package com.example.jaspreetsingh.selectlist;

/**
 * Created by jaspreet.singh on 17-05-2017.
 */

public class Names {

    String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    String lastName;

    public Names(String firstName, String lastName, boolean selected) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.selected = selected;
    }

    boolean selected = false;
}
