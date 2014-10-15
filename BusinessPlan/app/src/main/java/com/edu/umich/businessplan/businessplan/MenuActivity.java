// Florence Lee

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MenuActivity extends Activity {

	
	// if user clicks on Create New Plan, 
		// open activity MenuNewPlan

		// if user clicks on Client Information,
		// open activity ClientInformation

		// if user clicks on business Information,
		// open activity BusinessInformation

		// if user clicks on Your Customers,
		// open activity YourCustomers

		// if user clicks on Your Hours,
		// open activity YourHours

		// if user clicks on How is Business,
		// open activity HowIsBusiness

		// if user clicks on You & Your Community,
		// open activity YouAndYourCommunity

		// if user clicks on Suggestions for Improvement,
		// open activity SuggestionsForImprovement

		// if user clicks on Your Action Plan,
		// open activity ActionPlan

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
