// activity 1

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NewPlan extends BaseActivity {

    //create Shared Preferences object
    SharedPreferences sharedpreferences;
    final String prename = "mypref";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        //deletes shared preferences from previous plan
        clearCurrentBP();


    }

    public void clearCurrentBP() {
        // save values into sharedpreferences
        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        //editor.clear();

        editor.remove("name");
        editor.remove("city");
        editor.remove("household");
        editor.remove("income");
        editor.remove("suggestions");
        editor.remove("actions");

        editor.apply();

        String debugAllBP = mySharedPreferences.getString("Business Plan", "");
        Log.i("New Plan", "SP ALL BP " + debugAllBP);
    }

    //when user selects button1, load activity 2 (ClientInformation)//
    public void createPlan(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);

    }


    public void seePlans(View view) {
        Intent intent = new Intent(getApplicationContext(), PlansOverview.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_plan, menu);
        return true;
    }

}
