//Hannah
//This is Activity8

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//upon instantiation, display textView
    //from the suggestions algorithm, display suggestions as checkBox
    /*These are the recommendations overall


//if array rec_customer > 0
                //print "You should sell to" array rec customer" pseudo code pseudo code pseudo code
            //if rec_customer =0
                //exit

    Improvement plan for YourHours
    for day in list_Morning ()
    if day !=0
        morningTotal+=1
    if morningTotal <= 4
        print "We recommend that you are open more mornings."
    for day in list_Morning(5:6)
        if day != 0,
            weekendTotal +=1
    for day in list_Morning (0:4)
        if day !=0,
            weekdayTotal+=1
    for day in list_Evening ()
        if day !=0
            eveningTotal+=1
    if eveningTotal <= 4
        print "We recommend that you are open more evenings."
    for day in list_Evening(5:6)
        if day != 0,
            weekendTotal +=1
    for day in list_Evening (0:4)
        if day !=0,
            weekdayTotal+=1
    for day in list_Afternoon ()
        if day !=0
            afternoonTotal+=1
    if afternoonTotal <= 4
        print "We recommend that you are open more afternoons."
    for day in list_Afternoon(5:6)
        if day != 0,
            weekendTotal +=1
    for day in list_Afternoon (0:4)
        if day !=0,
            weekdayTotal+=1
    if weekendTotal <=3
        print "We recommend that you are open more on the weekends."
    if weekdayTotal <=8
        print "We recommend that you are open more weekdays."
        */

    //allow the user to select no more than five checkBox

//if the user selects back an onCLick event occurs
    //for the suggestions that the user selected (checkBox), create a new variable,
    // summary/Action Plan that includes only those suggestions

    // Activity7 (YouAndYourCommunity) loads


//if the user selects next an onClick event occurs
    //for the suggestions that the user selected (checkBox), create a new variable,
    // summary/Action Plan that includes only those suggestions

    //Activity9 (YourActionPlan) loads

public class SuggestionsForImprovement extends BaseActivity {

    // a list class type must be used when using a list view
// list items are added to a list view programatically and not through xml
    List<Map<String, String>> suggestionsMap = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions_for_improvement);

// we call this initiList function to fill in our list class variable with our team names
        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView teamListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, suggestionsMap, android.R.layout.simple_list_item_checked, new String[]{"suggestion"}, new int[]{android.R.id.text1});
        teamListView.setAdapter(simpleAdpt);

    }


    private void initList() {
        suggestionsMap.add(createSuggestion("suggestion", "Suggestion 1"));
        suggestionsMap.add(createSuggestion("suggestion", "Suggestion 2"));
        suggestionsMap.add(createSuggestion("suggestion", "Suggestion 3"));
    }
    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a team name into out list
    private HashMap<String, String> createSuggestion(String key, String name) {
        HashMap<String, String> Suggestion = new HashMap<String, String>();
        Suggestion.put(key, name);
        return Suggestion;
    }

    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YouAndYourCommunity.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ActionPlan.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.suggestions_for_improvement, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
