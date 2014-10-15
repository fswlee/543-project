//Hannah

//This is Activity 11
    //asks user if he/she really wants to create new plan
    //pop-out activity

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//on instantiation, display textViews and Buttons

//if the user selects Button1 ("Yes, create new plan") an onClick event occurs

    //Activity1 (NewPlan) loads


//if the user selects Button2 ("No, go back!") an onClick event occurs

    //Activity 11 (MenuNewPlan) is destroyed
    //Activity 10 (MenuActivity) is un-paused


public class MenuNewPlan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_new_plan);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_plan, menu);
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
