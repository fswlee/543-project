// activity 1

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NewPlan extends BaseActivity {

    private final String TAG = "Base Activity";
	

    //display textView1//
    //display button1//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        //deletes shared preferences from previous plan
        SharedPreferencesUtility.clearAll(this);
    }

    //when user selects button1, load activity 2 (ClientInformation)//
    public void createPlan(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);

    }

    //TODO change button to open plan summary
    public void seePlans(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_plan, menu);
        return true;
    }

}
