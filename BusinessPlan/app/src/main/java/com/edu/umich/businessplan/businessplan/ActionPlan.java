//This is Activity9

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.FragmentManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.content.Context;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.TextView;
import android.widget.Toast;
import android.os.*;

public class ActionPlan extends BaseActivity {

    //they will then be used to construct and modify a BusinessPlan object
    String bpClientName = ""; //name
    String bpCity = ""; //city
//    Integer bpHousehold = 0; //number of people in the household
//    Integer bpIncome = 0; //income
    List bpActions = new ArrayList<String>(); //list of Action Plan items
    String bpActionStringList = "";

    //create Shared Preferences object
    SharedPreferences sharedpreferences;
    final String prename = "mypref";

    // a list class type must be used when using a list view
// list items are added to a list view programatically and not through xml
    List<Map<String, String>> actionList = new ArrayList<Map<String,String>>();
    final Context context = this;
    List<Map<String, String>> summaryList=new ArrayList<Map<String, String>>();
    SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_plan);
        TextView name= (TextView)findViewById(R.id.name);
        TextView city= (TextView)findViewById(R.id.city);
//

        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        String name1 = mySharedPreferences.getString("name", " ");
        String city1 = mySharedPreferences.getString("city", " ");

        name.setText(name1);
        bpClientName = name1;
        city.setText(city1);
        bpCity = city1;


        bpActions = getSharedPreferences();


        String actionsListString = mySharedPreferences.getString("actions", "");
        Log.i("ActionPlan", "SP Actions: " + actionsListString);


        // adapters are what we use to associate the list variable and its contents with the list view
        ListView actionListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, bpActions, android.R.layout.simple_list_item_1, new String[] {"action"}, new int[] {android.R.id.text1});
        actionListView.setAdapter(simpleAdpt);

        Log.i("ActionPlan", "Action List: " + actionList);


    }

    public List getSharedPreferences() {
        //gets the suggestions from SP, key: "suggestions"

        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        //get the string of suggestions, delimited by ";"
        String actionsStringList = mySharedPreferences.getString("actions", "");

        bpActionStringList = actionsStringList;
        List returnList = constructActionsList(actionsStringList);


        return returnList;
    }

    public List constructActionsList(String stringList) {
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
               bpActions.add(createAction("action", i));
            }
        }

        return bpActions;
    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
// a team name into out list
    private HashMap<String, String> createAction(String key, String name) {
        HashMap<String, String> action = new HashMap<String, String>();
        action.put(key, name);
        return action;
    }


    public String stringListUtility(List list) {
        //takes in a List and returns a string with list items delimited by a ";"
        String listString = TextUtils.join(";;", list);

        return listString;
    }

    public void saveBusinessPlan() {
        //create BusinessPlan list from attributes
        List bpList = new ArrayList<String>();

        Log.i("ActionPlan", "client name in save method " + bpClientName);
        bpList.add(0,  bpClientName); //put a ";;" at the begining of each users BP
        bpList.add(1,  bpCity);
        bpList.add(2,  bpActionStringList);

        Log.i("ActionPlan", "BP list " + bpList);

        String bpListString = stringListUtility(bpList);

        bpListString += ";_;"; //put a ";;" at the end of each users BP
        Log.i("ActionPlan", "BP ListString w/ ;; " + bpListString);


        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        String currentBPString = mySharedPreferences.getString("Business Plan", "");
        String combinedBPString = currentBPString + bpListString;
        editor.putString("Business Plan", combinedBPString);

        editor.apply();

        String debugName = mySharedPreferences.getString("Business Plan","");
        Log.i("ActionPlan", "SP BP: " + debugName);


    }

//NAVIGATION
    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SuggestionsForImprovement.class);
        startActivity(intent);
    }

    //onClick of next button?
    //AlertDialog
    public void openNewPlan(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Are you sure you are done with the action plan?");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to submit your plan.")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //save users Business Plan
                        saveBusinessPlan();

                        // if this button is clicked, close
                        // current activity
                        Toast.makeText(getApplicationContext(), "Thank you! Your plan has been submitted. Returning to the main screen.", Toast.LENGTH_SHORT).show();



                        // delay the onClick event so that the Toast displays for a bit before the user
                        // gets brought back to the home page
                        // from http://stackoverflow.com/questions/17960922/delay-onclick-event-in-android
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ActionPlan.this.openCreateNewPlan();
                            }
                        }, 2000);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


// AlertDialog based on http://www.mkyong.com/android/android-alert-dialog-example/ tutorial


//ACTIONBAR MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_plan, menu);
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
