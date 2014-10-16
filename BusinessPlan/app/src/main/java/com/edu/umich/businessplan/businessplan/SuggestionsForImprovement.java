//Hannah
//This is Activity8

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//upon instantiation, display textView
    //from the suggestions algorithm, display suggestions as checkBox

    //allow the user to select no more than five checkBox

//if the user selects back an onCLick event occurs
    //for the suggestions that the user selected (checkBox), create a new variable,
    // summary/Action Plan that includes only those suggestions

    // Activity7 (YouAndYourCommunity) loads


//if the user selects next an onClick event occurs
    //for the suggestions that the user selected (checkBox), create a new variable,
    // summary/Action Plan that includes only those suggestions

    //Activity9 (YourActionPlan) loads

public class SuggestionsForImprovement extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions_for_improvement);
    }



    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YouAndYourCommunity.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ActionPlan.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.suggestions_for_improvement, menu);
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
