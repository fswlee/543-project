// Florence Lee

//This is Activity 4

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class YourCustomers extends Activity {

    // display the main menu button.
    // display the name of the page.
    // display first Q (where do you sell).
    // display 4 buttons with images in table view
    // display second Q (who do you sell to).
    // display 4 buttons with images in table view
    
    // If a user selects a button in the first table, change 
    // the state of that button from unselected to selected.
    
    // If a user selects a button in the second table, change 
    // the state of that button from unselected to selected.
 
    // When the user selects "button1" (next), an onClick event
    // is triggered. 
    
    	// Update the "where do you sell" variable in the algorithm
    	// that generates the recommendations to include the selected
    	// options.
    
        // Update the "who do you sell to" variable in the algorithm
        // that generates the recommendations to include the selected
        // options.
    
    	// Load the previous activity (BusinessInformation).

    // When the user selects "button2" (previous), an onClick event
    // is triggered. 
    
    	// Update the "where do you sell" variable in the algorithm
    	// that generates the recommendations to include the selected
    	// options.
    
        // Update the "who do you sell to" variable in the algorithm
        // that generates the recommendations to include the selected
        // options.
    
    	// Load the next activity (YourHours).
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_customers);

    }

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
