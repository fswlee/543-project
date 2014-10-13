// Florence Lee

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

	// display the main menu button.
	// display the name of the page.
	// display textview1 and textview3

	// display Graph using GraphView library? The first bar
	// data will use the city variable to lookup the poverty
	// level from the poverty level list. The value of the second bar
	// will be the value from the income variable. 

	// When the user selects "button1" (next), an onClick event
	// is triggered. Load the previous activity (HowIsBusiness).
	
	// When the user selects "button2" (previous), an onClick event
	// is triggered. Load the next activity (SuggestionsForImprovement).

public class YouAndYourCommunity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_and_your_community);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.you_and_your_community, menu);
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
