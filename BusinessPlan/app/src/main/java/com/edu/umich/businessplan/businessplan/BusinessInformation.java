// Activity 3

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.*;


public class BusinessInformation extends BaseActivity {


    SharedPreferences sharedpreferences;
    String prename = "mypref";

    // Focus is initially on describe your business textbox

    // income per month should be set up as a number input. field should only accept numbers
    // and symbols. when a user focuses on this field, the keyboard available for text
    // entry should be the keypad.
    // income per month should be stored in variable, income_per_month


    // put all user input into the database

    // if the user clicks on next, load activity 4, YourCustomers
    // if the user clicks on previous, load activity 2, Client Information

//    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_information);

    }




    //onClick of back button
    public void openPreviousActivity(View view) {

        // grab the value in the text field and convert to string
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String textentry = editText2.getText().toString();

        if (textentry.matches("")) {
            Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
            startActivity(intent);
        }
        else {
            // grab the text value and convert to a number
            int income = Integer.parseInt(textentry);

            // save value into sharedpreferences
            SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = mySharedPreferences.edit();

            editor.putInt("income", income);
            editor.apply();

            // go to the previous activity
            Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
            startActivity(intent);
        }
    }



    //onClick of forward button
    public void openNextActivity(View view) {

        // grab the value in the text field and convert to string
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String textentry = editText2.getText().toString();

        // if the user did not input a monthly income value, just go to the next screen
        if (textentry.matches("")) {
            Intent intent = new Intent(getApplicationContext(), YourCustomers.class);
            startActivity(intent);
        }
        else {
            // grab the text value and convert to a number
            int income = Integer.parseInt(textentry);

            // save value into sharedpreferences
            SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = mySharedPreferences.edit();

            editor.putInt("income", income);
            editor.apply();

            // go to the next activity
            Intent intent = new Intent(getApplicationContext(), YourCustomers.class);
            startActivity(intent);
        }


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
