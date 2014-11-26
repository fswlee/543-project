//This is Activity 8


package com.edu.umich.businessplan.businessplan;

import android.content.Intent;
import android.os.Bundle;
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

    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions_for_improvement);

        //Generate listView of suggestions from ArrayList
        displayListView();

    }
    int selectedCount = 0;

    private void displayListView() {
        //create an array list with class Suggestion (String, boolean) called suggestionList
        ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
        //create an instance of the class Suggestion (String, boolean)

        List<String> sharedList = new ArrayList<String>();
        sharedList = SharedPreferencesUtility.getStringList(this, "recommendation");

        for (String t: sharedList) {
            //create an instance of the class Suggestion (String, boolean)
            Suggestion suggestion = new Suggestion(t,false);

            //add the instance to the array list, suggestionList
            suggestionList.add(suggestion);

        }


        //create an ArrayAdaptar from the Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.suggestion_info, suggestionList);
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


    //initialize an empty list to hold the suggestions that are checked (and will need to appear on
    // the next activity
    List<String> actionList = new ArrayList<String>(); //empty list

//TODO implement another dialog alert box to appear if the actionList includes fewer than 3 actions
    //adds an action to actionList when it is checked
    public void addAction(String action) {
        actionList.add(action);
        Log.i("SuggestionsForImprovement", "Action List: " + actionList);
        calculateActions(actionList);

        //DEBUGGING - use the lines below to test whether the correct suggestions were added
        //actionList = SharedPreferencesUtility.getStringList(this, "action");
        //Log.i("MyActivity", "sharedPreferences " + actionList);
    }

    //removes an action from actionList when it is unchecked
    public void removeAction(String action) {
        actionList.remove(action);
        calculateActions(actionList);
        Log.i("MyActivity", "Action List: " + actionList);
    }

    //adds the list of actions to sharedPreferences for display on ActionPlan activity
    public void calculateActions(List actionList) {
        SharedPreferencesUtility.putStringList(this, "action", actionList);
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