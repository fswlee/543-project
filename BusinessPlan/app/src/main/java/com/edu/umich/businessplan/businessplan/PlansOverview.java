package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlansOverview extends BaseActivity {

    List<Map<String, String>> clientList = new ArrayList<Map<String,String>>();
    final Context context = this;

    //Intent previousActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_overview);


        // we call this initiList function to fill in our list class variable with our team names
        initList();

// adapters are what we use to associate the list variable and its contents with the list view
        ListView clientListView = (ListView) findViewById(R.id.listView1);
        SimpleAdapter mySimpleAdapter = new SimpleAdapter(this, clientList, android.R.layout.simple_list_item_1, new String[] {"client"}, new int[] {android.R.id.text1});
        clientListView.setAdapter(mySimpleAdapter);

    }

    // initList simply adds our team names to the list variable
// in a real app, this would be where we query our database to retrieve the list of teams, but
// we can perform some shared preferences data storing for now


    private void initList() {
        List<String> clientList2 = SharedPreferencesUtility.getStringList(this, "client");
        Log.i("MyActivity", "What The Hell is Happening: " + clientList2);
        for(String t: clientList2) {
            clientList.add(createClient("client", t));
        }
    }


    // this method helps us minimize the amount of repeat calls we need to make in initList to place
//a team name into out list
    private HashMap<String, String> createClient(String key, String t) {
        HashMap<String, String> client = new HashMap<String, String>();
        client.put(key, t);
        return client;
    }



    //if user selects "close" the NewPlan activity opens
    //when user selects button1, load activity 2 (ClientInformation)//
    public void goBack(View view) {
        Intent intent = new Intent(getApplicationContext(), NewPlan.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.plans_overview, menu);
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
