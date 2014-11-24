//This is Activity2

// TODO For the dropdowns, number of people in household over 18 must be less than or equal to total number of people in household

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information);


        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, num_people);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        int position = spinner.getSelectedItemPosition();

                        //create a variable of type SharedPreferences:
                        SharedPreferences sharedpreferences;
                        String prename="mypref";

                        int folks = spinner.getSelectedItemPosition();

                        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = mySharedPreferences.edit();

                        editor.putInt("num_people",folks);

                        editor.apply();

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }



                }


        );

        spinner18 = (Spinner)findViewById(R.id.spinner18);
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

        if(view.getId() == R.id.imageButton1){
            city.setBackgroundColor(Color.BLACK);
            suburb.setBackgroundColor(Color.rgb(45,196,137));
            rural.setBackgroundColor(Color.rgb(45,196,137));
        }
        else if (view.getId() == R.id.imageButton2) {
            suburb.setBackgroundColor(Color.BLACK);
            city.setBackgroundColor(Color.rgb(45,196,137));
            rural.setBackgroundColor(Color.rgb(45,196,137));
        }
        else if (view.getId() == R.id.imageButton3) {
            rural.setBackgroundColor(Color.BLACK);
            suburb.setBackgroundColor(Color.rgb(45,196,137));
            city.setBackgroundColor(Color.rgb(45,196,137));
        }

    }

    //onCLick of next button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BusinessInformation.class);
        startActivity(intent);
    }

//display textView1, textView2, textView3, textView4, editText1, editText2, editText3, editText4,
//imageButton1, imageButton2, imageButton3, and imageButton4

  //activate keyboard if the user selects any of the editText objects

  //For "where do you live" buttons, user can only select one of the three buttons. Keep the value
  // the user selects in variable, location.

  //if the user selected the forward button, an onClick event is triggered

    // put all user input into a database
    // keep # of people in household as variable household
    // keep # of people in household over 18 as variable over18

    // load activity 3 (BusinessInformation)

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
