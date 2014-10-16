// Florence Lee
//This is Activity10

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MenuActivity extends Activity {

	
	// if user clicks on Create New Plan, 
		// open activity MenuNewPlan

    public void openMenuNewPlan(View view) {
        Intent intent = new Intent(getApplicationContext(), MenuNewPlan.class);
        startActivity(intent);
    }

		// if user clicks on Client Information,
		// open activity ClientInformation

    public void openClientInformation(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);
    }

		// if user clicks on business Information,
		// open activity BusinessInformation

    public void openBusinessInformation(View view) {
        Intent intent = new Intent(getApplicationContext(), BusinessInformation.class);
        startActivity(intent);
    }
		// if user clicks on Your Customers,
		// open activity YourCustomers

    public void openYourCustomers(View view) {
        Intent intent = new Intent(getApplicationContext(), YourCustomers.class);
        startActivity(intent);
    }

		// if user clicks on Your Hours,
		// open activity YourHours

    public void openYourHours(View view) {
        Intent intent = new Intent(getApplicationContext(), YourHours.class);
        startActivity(intent);
    }

		// if user clicks on How is Business,
		// open activity HowIsBusiness

    public void openHowIsBusiness(View view) {
        Intent intent = new Intent(getApplicationContext(), HowIsBusiness.class);
        startActivity(intent);
    }
		// if user clicks on You & Your Community,
		// open activity YouAndYourCommunity

    public void openYouAndYourCommunity(View view) {
        Intent intent = new Intent(getApplicationContext(), YouAndYourCommunity.class);
        startActivity(intent);
    }

		// if user clicks on Suggestions for Improvement,
		// open activity SuggestionsForImprovement

    public void openSuggestionsForImprovement(View view) {
        Intent intent = new Intent(getApplicationContext(), SuggestionsForImprovement.class);
        startActivity(intent);
    }

		// if user clicks on Your Action Plan,
		// open activity ActionPlan

        public void openActionPlan(View view) {
            Intent intent = new Intent(getApplicationContext(), ActionPlan.class);
            startActivity(intent);
        }

		// if user clicks on the X button, 
		// close this activity and show the user the
		// previous activity they were on.
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
