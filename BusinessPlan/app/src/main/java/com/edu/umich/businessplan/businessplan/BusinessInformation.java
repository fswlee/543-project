// Activity 3

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class BusinessInformation extends Activity {


    // Store whether the user selects city, suburban, or rural
    // in a variable, location.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_information);
    }

    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YourCustomers.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.business_information, menu);
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
