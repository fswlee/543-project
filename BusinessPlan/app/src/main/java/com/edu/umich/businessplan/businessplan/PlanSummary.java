package com.edu.umich.businessplan.businessplan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/**
 * Created by Jackie on 12/2/2014.
 */
public class PlanSummary extends BaseActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_summary);

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



    //Button Navigation
    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ActionPlan.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNewPlan(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Are you sure you are done with your business plan?");

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
                                PlanSummary.this.openCreateNewPlan();
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

    //Action Bar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.plan_summary, menu);
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
