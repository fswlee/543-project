package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ClientInformation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_information);

    }


    public void openActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BusinessInformation.class);
        startActivity(intent);
    }
//display textView1, textView2, textView3, textView4, editText1, editText2, editText3, editText4,
//imageButton1, imageButton2, imageButton3, and imageButton4

  //activate keyboard if the user selects any of the editText objects

  //if the user touches any of the image buttons in the first horizantal linear layout, the button
  //goes from unselected. only one of the three buttons can be selected at one time

  //if the user selected the forward button, an onClick event is triggered

    //the algorithm that generated the You and Your Community Graph is updated to include
    //information from questions 2, 3, and 4

    //activity 3 (BusinessInformation) loads

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client_information, menu);
        return true;
    }

    //load activity 3
    public void openActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);
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
