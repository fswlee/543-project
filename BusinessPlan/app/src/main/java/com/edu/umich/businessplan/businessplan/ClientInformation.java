//This is Activity2

// TODO For the dropdowns, number of people in household over 18 must be less than or equal to total number of people in household

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;


public class ClientInformation extends BaseActivity {


    // create spinners
    Spinner spinner;
    Spinner spinner18;

    // array of available options
    String[] num_people = {
            " ",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "more than 8"
    };

    //these variables will be altered based on user input
    //they will then be used to construct and modify a BusinessPlan object
    String bpClientName = ""; //name
    String bpCity = ""; //city
    Integer bpHousehold = 0; //number of people in the household

    //create Shared Preferences object
    SharedPreferences sharedpreferences;
    final String prename = "mypref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //create a variable of type SharedPreferences:




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information);

        //use code below to grab text after focus changes

        EditText editText = (EditText) findViewById(R.id.editText1);


        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);


        // add listener to capture the name the user inputs after the user inputs it
        TextWatcher generalTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                //grab input from editText1 after focus has changed - convert to String
                //add the client name to shared preferences
                editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) { //SAVE the DATA
                            final String name = editText1.getText().toString();
                            bpClientName = name;
                            Log.i("Client Information", "Getting name " + bpClientName);
                        }

                    }
                });

                //grab input from editText2 after focus has changed - convert to String
                //add the city to shared preferences
                editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus) { //SAVE the DATA
                            final String city = editText2.getText().toString();
                            bpCity = city;
                            Log.i("Client Information", "Getting city " + bpCity);
                        }

                    }
                });


            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        editText1.addTextChangedListener(generalTextWatcher);
        editText2.addTextChangedListener(generalTextWatcher);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, num_people);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        int position = spinner.getSelectedItemPosition();


                        int num_people = spinner.getSelectedItemPosition();
                        bpHousehold = num_people;

//                        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = mySharedPreferences.edit();
//
//                        editor.putInt("num_people", folks);
//
//                        editor.apply();


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }


                }


        );

        spinner18 = (Spinner) findViewById(R.id.spinner18);
        ArrayAdapter<String> adapter_18 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, num_people);
        spinner18.setAdapter(adapter_18);
        spinner18.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        int position = spinner18.getSelectedItemPosition();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }
                }
        );

        // spinner code from http://www.learn2crack.com/2013/12/android-spinner-dropdown-example.html
    }


    //method for changing the background color of selected buttons
    public void selectButton(View view) {

        ImageButton city = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton suburb = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton rural = (ImageButton) findViewById(R.id.imageButton3);

        //if a button is selected
        //  that button's background color changes
        //  the other buttons' background color change to their original color

        if (view.getId() == R.id.imageButton1) {
            city.setBackgroundColor(Color.BLACK);
            suburb.setBackgroundColor(Color.rgb(45, 196, 137));
            rural.setBackgroundColor(Color.rgb(45, 196, 137));
        } else if (view.getId() == R.id.imageButton2) {
            suburb.setBackgroundColor(Color.BLACK);
            city.setBackgroundColor(Color.rgb(45, 196, 137));
            rural.setBackgroundColor(Color.rgb(45, 196, 137));
        } else if (view.getId() == R.id.imageButton3) {
            rural.setBackgroundColor(Color.BLACK);
            suburb.setBackgroundColor(Color.rgb(45, 196, 137));
            city.setBackgroundColor(Color.rgb(45, 196, 137));
        }

    }

    //called when user clicks next button - creates a BusinessPlan Object
        //saves BusinessPlan object to SharedPreferences
//    public void initBusinessPlan() {
//    //create a business plan object with the name, city, and income
//
//        BusinessPlan businessPlan = new BusinessPlan(bpClientName);
//        Log.i("Client Information", "creating BP" + businessPlan.getName());
//        businessPlan.setCity(bpCity);
//        businessPlan.setHousehold(bpHousehold);
//
//        //add the BP to SharedPreferences
//        SharedPreferencesUtility.putBusinessPlan(this, "Business Plan", businessPlan);
//        //"Business Plan": "name;;city;;household;;income;;Suggestion;;action"
//
//    }

    public void addSharedPreferences() {
        // save values into sharedpreferences
        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        editor.putString("name", bpClientName);
        editor.putString("city", bpCity);
        editor.putInt("household", bpHousehold);
        editor.apply();

        String debugName = mySharedPreferences.getString("name","");
        Log.i("Client Information", "SP name: " + debugName);

        String debugCity = mySharedPreferences.getString("city", "");
        Log.i("Client Information", "SP city: " + debugCity);

        int debugHousehold = mySharedPreferences.getInt("household", 0);
        Log.i("Client Information", "SP household: " + debugHousehold);

    }

//NAVIGATION
    //onCLick of next button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BusinessInformation.class);
        //initBusinessPlan(); //create new BusinessPlan
        addSharedPreferences();
        startActivity(intent); //go to next activity

//        Log.i("Client Information", "Name: " + bpClientName);
//        Log.i("Client Information", "City: " + bpCity);
    }

//ACTION BAR MENU -- see BaseActivity.java
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client_information, menu);
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
