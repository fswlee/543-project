//This is Activity9

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Toast;
import android.os.*;

public class ActionPlan extends BaseActivity {

    // a list class type must be used when using a list view
// list items are added to a list view programatically and not through xml
    List<Map<String, String>> actionList = new ArrayList<Map<String,String>>();
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_plan);

        //initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView actionListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, actionList, android.R.layout.simple_list_item_1, new String[] {"action"}, new int[] {android.R.id.text1});
        actionListView.setAdapter(simpleAdpt);

        Log.i("ActionPlan", "Action List: " + actionList);

        initList();
    }

    public void initList() {
        List<String> displayActionsList = SharedPreferencesUtility.getStringList(this, "action");
        for(String t: displayActionsList) {
            actionList.add(createAction("action", t));
        }
    }


    // this method helps us minimize the amount of repeat calls we need to make in initList to place
// a team name into out list
    private HashMap<String, String> createAction(String key, String name) {
        HashMap<String, String> action = new HashMap<String, String>();
        action.put(key, name);
        return action;
    }




//Navigation
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


//Actionbar Menu
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
