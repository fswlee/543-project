//This is Activity 8


package com.edu.umich.businessplan.businessplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.AdapterView.OnItemClickListener;

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

    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions_for_improvement);

        //Generate list View from ArrayList
        displayListView();

    }

    private void displayListView() {

        //create an array list with class Suggestion (String, boolean) called suggestionList
        ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();

        //create an instance of the class Suggestion (String, boolean)
        Suggestion suggestion = new Suggestion("Suggestion 1",false);

        //add the instance to the array list, suggestionList
        suggestionList.add(suggestion);

        //create new instances of the class and add them to the array
        suggestion = new Suggestion("Suggestion 2",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 3",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 4",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 5",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 6",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 7",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 8",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 9",false);
        suggestionList.add(suggestion);
        suggestion = new Suggestion("Suggestion 10",false);
        suggestionList.add(suggestion);

        //create an ArrayAdaptar from the Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.suggestion_info, suggestionList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

    }

    private class MyCustomAdapter extends ArrayAdapter<Suggestion> {

        private ArrayList<Suggestion> suggestionList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Suggestion> suggestionList) {
            super(context, textViewResourceId, suggestionList);
            this.suggestionList = new ArrayList<Suggestion>();
            this.suggestionList.addAll(suggestionList);
        }

        private class ViewHolder {
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.suggestion_info, null);

                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Suggestion suggestion = suggestionList.get(position);
            holder.name.setText(suggestion.getName());
            holder.name.setChecked(suggestion.isSelected());
            holder.name.setTag(suggestion);

            return convertView;

        }

    }

    //Button Navigation

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


    //Action Bar Menu
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


//The dataAdapter and Checkbox ListView was adapted from
//http://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html