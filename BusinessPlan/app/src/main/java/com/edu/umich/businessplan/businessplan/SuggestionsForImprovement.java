//This is Activity 8


package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class SuggestionsForImprovement extends BaseActivity {

    //create Shared Preferences object
    SharedPreferences sharedpreferences;
    final String prename = "mypref";
    MyCustomAdapter dataAdapter = null;

    List bpSuggestions = new ArrayList<String>();
    List bpActions = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions_for_improvement);

        //gets SharedPreferences
        bpSuggestions = getSharedPreferences();

        //Generates listView of suggestions from ArrayList
        displayListView(bpSuggestions);

    }
    int selectedCount = 0;

    public List getSharedPreferences() {
        //gets the suggestions from SP, key: "suggestions"

        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        //get the string of suggestions, delimited by ";"
        String suggestionsStringList = mySharedPreferences.getString("suggestions", "");

        List returnList = constructSuggestions(suggestionsStringList);

        return returnList;
    }

    public List constructSuggestions(String stringList) {
        //takes a string of suggestions delimited by ";" and returns a List of suggestions
        List<String> list = new ArrayList<String>(); //default list

        if(stringList.length() != 0) {
        // string.split will create an array returning everything in between the provided "delimiter"
        // parameter
        // example: if the string is hello;world;!, calling split(";") on it would return an array
        // with 3 items: "hello", "world", and "!"
            String[] items = stringList.split(";");
// loop through the array and add it to a list so we can give it back to the method caller
            for (String i : items) {
                list.add(i);
            }
        }

        return list;
    }

    private void displayListView(List list) {
        //create an array list with class Suggestion (String, boolean) called suggestionList
        ArrayList<Suggestion> suggestionClassList = new ArrayList<Suggestion>();
        List<String> suggestionList = list;
        //create an instance of the class Suggestion (String, boolean)


        for (String t: suggestionList) {
            //create an instance of the class Suggestion (String, boolean)
            Suggestion suggestion = new Suggestion(t,false);

            //add the instance to the array list, suggestionList
            suggestionClassList.add(suggestion);

        }


        //create an ArrayAdaptar from the Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.suggestion_info, suggestionClassList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Suggestion suggestion = (Suggestion) parent.getItemAtPosition(position);

                //DEBUGGING
                //Toast.makeText(getApplicationContext(),
                //        "Clicked on Row: " + suggestion.getName(),
                //        Toast.LENGTH_LONG).show();
            }
        });


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

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        CharSequence actionCharSequence = cb.getText();
                        String action = actionCharSequence.toString();
                        Suggestion suggestion= (Suggestion) cb.getTag();
                        if (cb.isChecked()== true) {
                            selectedCount += 1;
                            addAction(action);

                        }
                        else {
                            selectedCount -= 1;
                            removeAction(action);
                        }

                        Log.i("MyActivity", "sharedPreferences " + action);

                        //DEBUGGING toast
                        //Toast.makeText(getApplicationContext(),
                        //        "Clicked on Checkbox: " + cb.getText() +
                        //                " is " + cb.isChecked(),
                        //        Toast.LENGTH_LONG).show();
                        //suggestion.setSelected(cb.isChecked());
                    }
                });
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



    //adds an action to actionList when it is checked
    public void addAction(String action) {
        bpActions.add(action);
        Log.i("SuggestionsForImprovement", "Action Added: " +  action);
        Log.i("SuggestionsForImprovement", "Updated Action List: " + bpActions);
        //calculateActions(bpActions);


        //DEBUGGING - use the lines below to test whether the correct suggestions were added
        //actionList = SharedPreferencesUtility.getStringList(this, "action");
        //Log.i("MyActivity", "sharedPreferences " + actionList);
    }

    //removes an action from actionList when it is unchecked
    public void removeAction(String action) {
        bpActions.remove(action);
        Log.i("SuggestionsForImprovement", "Action Removed: " +  action);
        Log.i("SuggestionsForImprovement", "Updated Action List: " +  bpActions);
        //calculateActions(bpActions);
    }

    public String stringListUtility(List list) {
        //takes in a List and returns a string with list items delimited by a ";"
        String listString = TextUtils.join(";", list);

        return listString;
    }

    //adds the list of actions to sharedPreferences for display on ActionPlan activity
    public void calculateActions(List actionList) {

        String actionStringList = stringListUtility(actionList);

        // save values into sharedpreferences
        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        editor.putString("actions", actionStringList);
        editor.apply();

        String debugActions = mySharedPreferences.getString("actions", "");
        Log.i("SuggestionsForImprovement", "SP actions: " + debugActions);

        //check complete SharedPreferences
        Log.i("SuggestionsForImprovement", "SP ALL: " + mySharedPreferences.getAll());


    }


//NAVIGATION
    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YouAndYourCommunity.class);
        calculateActions(bpActions);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ActionPlan.class);
        calculateActions(bpActions);
        startActivity(intent);
    }

//ACTIONBAR MENU
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