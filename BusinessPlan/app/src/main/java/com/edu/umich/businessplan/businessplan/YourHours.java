//Hannah
package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//display textViews and Buttons upon activity instantiation

//if the user selects any, button change its state from unselected to selected. the user can select
//as many buttons as he or she wants

//if the user selects the back button an onClick event occurs

    //Activity4 (YourCustomers) loads

    //the algorithm that generates suggestions for improvement is updated to include the number
    //of buttons selected
        //determine how many weekend shifts
        //determine how many morning, afternoon, evening shifts

//if the user selects the forward button an onClick event occurs

    //Activity6 (HowIsBusiness) loads

    //the algorithm that generates suggestions for improvement is updated to include the number
    //of buttons selected
        //determine how many weekend shifts
        //determine how many morning, afternoon, evening shifts

public class YourHours extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_hours);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.your_hours, menu);
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
