package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannah Brookhart on 12/7/2014.
 */


//for shared preferences: only one key the name, access other prefs via index
    //"client name": city (0), income (1), suggestionsList (2), actionsList (3)
    //shared prefs: key is a string, client name
    //value is a list with 4 elements: [String city, int income, List suggestionsList(list of Suggestions), List actionsList(Strings)
public class BusinessPlan {
//a business plan is generated for each user
    String name;
    String city;
    Integer household; //number of people in household
    Integer income;
    List<Suggestion> suggestions;
    List<String> actions;

    //constructor creates BusinessPlan object using name and city
        //also includes default income, suggestions, and actions (all empty)
    public BusinessPlan(String name) {
        super();
        this.name = name;
        this.city = "";
        this.actions = new ArrayList<String>();
    }

    //there is no set for name or because this is set using the constructor and should not
    //be changed



    public String getName() {
        //gets the String name
        return name;
    }

    public void setCity(String clientCity) {
        //sets the String city (in CLientInformation.java)
        city = clientCity;
    }


    public String getCity() {
        //gets the String city
        return city;
    }

    public void setHousehold(int numHousehold) {
        //sets the number of people in the household (captured in ClientInformation.java and used
        // in YouAndYourCommunity.java
        household = numHousehold;
    }

    public int getHousehold() {
        //gets the integer - number of people in the household
        return household;
    }

    public void setIncome(int clientIncome) {
        //sets the income (used in BusinessInformation.java)
        income = clientIncome;
    }

    public Integer getIncome() {
        //gets the income (used in ActionPlan.java and YouAndYourCommunity.java)
        return income;
    }

    public void addSuggestions(Suggestion suggestion) {
        //adds a suggestion to the list of suggestions (class Suggestion(String, Boolean)
        //these are added on YourCustomers and YourHours
        suggestions.add(suggestion);
    }

    public void removeSuggestions(Suggestion suggestion) {
        //removes a suggestion from the list of suggestions (class Suggestion(String, Boolean)
        suggestions.remove(suggestion);
    }

    public List getSuggestions() {
        //returns a list of Suggestions (String,Boolean)
        return suggestions;
    }

    public void addActions(String action) {
        //adds an action to the list of actions
        //actions are added on SuggestionsForImprovement.java when a user selects a checkbox
        actions.add(action);
    }

    public List getActions() {
        //returns a list of actions(Strings)
        return actions;
    }


}
