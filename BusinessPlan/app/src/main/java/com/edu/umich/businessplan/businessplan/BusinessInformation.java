// Activity 3

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.*;


public class BusinessInformation extends BaseActivity {

    //the BP is created only when user submits - otherwise save attributes under their individual key
        // example: "name": Hannah
        // "city": "Troy"

    //when the user saves their plan, a new method will grab all of these prefs and use them to construct a BP, which will be saved
        //under the key, "Business Plan"
    //this SP won't be deleted, but when a user starts a new plan, the other SPs will be cleared


    //these variables will be altered based on user input
    //they will then be used to construct and modify a BusinessPlan object
    Integer bpIncome = 0; //number of people in the household

    String prename = "mypref";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_information);

        EditText editText = (EditText) findViewById(R.id.editText1);
        // grab the value in the text field and convert to string
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        // add listener to capture the income value the user inputs after the user inputs it
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                final String stringIncome = editText2.getText().toString();
                bpIncome = Integer.parseInt(stringIncome);
                Log.i("Business Information", "Getting income: " + bpIncome);
            }
        });
    }

//    public void editBusinessPlan() {
//        String bpListString = "";
//        //get the existing BP list from SP
//            //construct the business plan using the income
//            //remove the BP from SP and add the new one
//
//        //grab the BP list from SP
//            //edit the list to include an the user input income
//            //re-save to SP
//        //create a business plan object with the name, city, and income
//
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.getClass(); //Add the BP object to shared prefs
//        //it looks like this:
//        //"Business Plan": "name;;city;;household;;income;;suggestion;suggestion;suggestion;;action;action;action"
//        editor.apply();
//
//
//
//
//        Log.i("Business Information", "editBusinessPlan() is called");
//        //SharedPreferencesUtility.getBusinessPlan(this, "Business Plan");
//
//        //add the BP to SharedPreferences
//        //SharedPreferencesUtility.putBusinessPlan(this, "Business Plan", businessPlan);
//        //"Business Plan": "name;;city;;household;;income;;Suggestion;;action"
//
//    }

    public void addSharedPreferences() {
        // saves users income to SharedPreferences using key, "income"
        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        editor.putInt("income", bpIncome);
        editor.apply();

        Integer debugIncome = mySharedPreferences.getInt("income",0);
        Log.i("Client Information", "SP name: " + debugIncome);

        //check the current SharedPreferences map
        Log.i("Client Information", "SP ALL: " + mySharedPreferences.getAll());
    }

//NAVIGATION
    //onClick of back button
    public void openPreviousActivity(View view) {
            Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
            //editBusinessPlan();
            addSharedPreferences();
            startActivity(intent);
        }


    //onClick of forward button
    public void openNextActivity(View view) {
            Intent intent = new Intent(getApplicationContext(), YourCustomers.class);
            //editBusinessPlan();
            addSharedPreferences();
            startActivity(intent);
        }

//ACTIONBAR MENU
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
