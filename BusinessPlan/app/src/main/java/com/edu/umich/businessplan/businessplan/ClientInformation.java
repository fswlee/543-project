//This is Activity2

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;



public class ClientInformation extends Activity {

    Spinner spinner;
    String[] num_people = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "more than 6"
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
                        Toast.makeText(getApplicationContext(),"You have selected "+num_people[+position],Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }
                }
        );



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
