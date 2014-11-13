// Florence Lee

//This is Activity 4

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class YourCustomers extends BaseActivity {

    // display the main menu button.
    // display the name of the page.
    // display first Q (where do you sell).
    // display 4 buttons with images in table view
    // display second Q (who do you sell to).
    // display 4 buttons with images in table view
    
    // If a user selects a button in the first table, change 
    // the state of that button from unselected to selected.
    // User should be able to select as many as they want.

        //Each button is it's own variable. e.g. location_home, location_neighborhood, location_store
        //location_cart

        //If selected, that variable =1, if not, variable=0
    
    // If a user selects a button in the second table, change 
    // the state of that button from unselected to selected.
    // User should be able to select as many as they want.

        //each button is it's own variable, e.g. customer_family, customer_friends, customer_neighbors
        //customer_public

        //if selected, that variable =1, if not, variable=0
        //Suggestions for Improvement for Business plan Business plan
            //if customer_family =0, append  "family" to array rec_customer
            //if customer_friends=0, append  "friends" to array rec_customer
            //if customer_neighbors=0, append "neighbors" to array rec_customer
            //if customer_public=0, append "public" to array rec_customer

    // When the user selects "button1" (next), an onClick event
    // is triggered.

    
    	// Update the location variables in the algorithm
    	// that generates the recommendations to include the selected
    	// options.
    
        // Update the customer variables in the algorithm
        // that generates the recommendations to include the selected
        // options.
    
    	// Load the previous activity (BusinessInformation).

    // When the user selects "button2" (previous), an onClick event
    // is triggered. 
    
    	// Update the location variables in the algorithm
    	// that generates the recommendations to include the selected
    	// options.
    
        // Update the customer variables in the algorithm
        // that generates the recommendations to include the selected
        // options.
    
    	// Load the next activity (YourHours).
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_customers);

    }

    //create buttonSelected method
        //create 2 variables for each of the 8 buttons (one for color, one for selected (0 or 1)
        //create 2 variables for total selected whereSellTotal, whomSellTotal
        //for each button:
            //change color from green to black
            //change the selected variable to 1
            //if buttonID is in WhereSell and selected variable is 1:
                //add 1 to the WhereSellTotal
            //else if butonID is in WhomSell and selected variable is 1:
                //add 1 to the WhomSellTotal

    //if total for WhereDoYouSell buttons is < 2;
        //if sell_home is 0:
            //recommendationList.add("Try selling at home.");
        //else if sell_neighborhood is 0;
            //recommendationList.add("Try selling in your neighborhood")
    //SharedPreferencesUtility.putStringList(this, "recommendations", recommendationList);

    //if total for WhomDoYouSellTo buttons is < 2;
        //if sell_family is 0:
            //recommendationList.add("Try selling to your family.");
        //else if sell_neighbors is 0;
            //recommendationList.add("Try selling in your neighbors")
    //SharedPreferencesUtility.putStringList(this, "recommendations", recommendationList);


    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), BusinessInformation.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YourHours.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.your_customers, menu);
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
