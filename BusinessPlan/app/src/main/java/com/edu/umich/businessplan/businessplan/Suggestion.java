package com.edu.umich.businessplan.businessplan;

/**
 * Created by Hannah Brookhart on 11/11/2014.
 */

//This class is used in SuggestionsForImprovement.java
public class Suggestion {

    //String code = null;
    String name = null; //create a variable, name, and set it to null
    boolean selected = false; //create a variable, selected, and set it to false

    //create class Suggestion with two attributes
    public Suggestion(String name, boolean selected) {
        super();
        this.name = name;
        this.selected = selected;
    }

    //method to get the string
    public String getName() {
        return name;
    }

    //method to set the string
    public void setName(String name) {
        this.name = name;
    }

    //method to return the status of the checkbox (either selected/True or unselected/False)
    public boolean isSelected() {
        return selected;
    }

    //method to set the checkbox as either selected/True or unselected/False
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
