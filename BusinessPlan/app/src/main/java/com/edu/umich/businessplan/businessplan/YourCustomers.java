// Florence Lee

//This is Activity 4

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


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

        //clear the suggestion list from shared preferences
        SharedPreferencesUtility.clearSuggestionList(this, "recommendation");

    }

    //initialize variables for first table (Where Do You Sell?)
    boolean selectedHome = false;
    boolean selectedNeighborhood = false;
    boolean selectedCart = false;
    boolean selectedStore = false;
    int whereTotal = 0;

    //initialize variables for second table (To Whom Do You Sell?)
    boolean selectedFamily = false;
    boolean selectedFriends = false;
    boolean selectedNeighbors = false;
    boolean selectedPublic = false;
    int whoTotal = 0;

    public void selectCustomers(View view) {
        ImageButton sell_home = (ImageButton) findViewById(R.id.buttonHome);
        ImageButton sell_neighborhood = (ImageButton) findViewById(R.id.buttonNeighborhood);
        ImageButton sell_cart = (ImageButton) findViewById(R.id.buttonCart);
        ImageButton sell_store = (ImageButton) findViewById(R.id.buttonStore);

        ImageButton sellto_family = (ImageButton) findViewById(R.id.buttonFamily);
        ImageButton sellto_friends = (ImageButton) findViewById(R.id.buttonFriends);
        ImageButton sellto_neighbors = (ImageButton) findViewById(R.id.buttonNeighbors);
        ImageButton sellto_public = (ImageButton) findViewById(R.id.buttonPublic);

        if (view.getId() == R.id.buttonHome) {
            if (selectedHome == false) {
                sell_home.setBackgroundColor(Color.BLACK);
                selectedHome = true;
                whereTotal += 1;
            } else {
                sell_home.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedHome = false;
                whereTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whereTotal);
            Log.i("MyActivity", "Home Selected? " + selectedHome);
        }

        else if (view.getId() == R.id.buttonNeighborhood) {
            if (selectedNeighborhood == false) {
                sell_neighborhood.setBackgroundColor(Color.BLACK);
                selectedNeighborhood = true;
                whereTotal += 1;
            } else {
                sell_neighborhood.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedNeighborhood = false;
                whereTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whereTotal);
            Log.i("MyActivity", "Neighborhood Selected? " + selectedNeighborhood);
        }

        else if (view.getId() == R.id.buttonCart) {
            if (selectedCart == false) {
                sell_cart.setBackgroundColor(Color.BLACK);
                selectedCart = true;
                whereTotal += 1;
            } else {
                sell_cart.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedCart = false;
                whereTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whereTotal);
            Log.i("MyActivity", "Cart Selected? " + selectedCart);
        }

        else if (view.getId() == R.id.buttonStore) {
            if (selectedStore == false) {
                sell_store.setBackgroundColor(Color.BLACK);
                selectedStore = true;
                whereTotal += 1;
            } else {
                sell_store.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedStore = false;
                whereTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whereTotal);
            Log.i("MyActivity", "Store Selected? " + selectedStore);
        }

        if (view.getId() == R.id.buttonFamily) {
            if (selectedFamily == false) {
                sellto_family.setBackgroundColor(Color.BLACK);
                selectedFamily = true;
                whoTotal += 1;
            } else {
                sellto_family.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedFamily = false;
                whoTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whoTotal);
            Log.i("MyActivity", "Family? " + selectedFamily);
        }
        else if (view.getId() == R.id.buttonFriends) {
            if (selectedFriends == false) {
                sellto_friends.setBackgroundColor(Color.BLACK);
                selectedFriends = true;
                whoTotal += 1;
            } else {
                sellto_friends.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedFriends = false;
                whoTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whoTotal);
            Log.i("MyActivity", "Friends? " + selectedFriends);
        }
        else if (view.getId() == R.id.buttonNeighbors) {
            if (selectedNeighbors == false) {
                sellto_neighbors.setBackgroundColor(Color.BLACK);
                selectedNeighbors = true;
                whoTotal += 1;
            } else {
                sellto_neighbors.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedNeighbors = false;
                whoTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whoTotal);
            Log.i("MyActivity", "Neighbors? " + selectedNeighbors);
        }
        else if (view.getId() == R.id.buttonPublic) {
            if (selectedPublic == false) {
                sellto_public.setBackgroundColor(Color.BLACK);
                selectedPublic = true;
                whoTotal += 1;
            } else {
                sellto_public.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedPublic = false;
                whoTotal -= 1;
            }
            Log.i("MyActivity", "Where Total " + whoTotal);
            Log.i("MyActivity", "Public? " + selectedPublic);
        }
        Log.i("MyActivity", "Who Total: " + whoTotal);
        Log.i("MyActivity", "Where Total: " + whereTotal);
        calculateRecommendations();
    }


    public void calculateRecommendations() {
        List<String> suggestionList = new ArrayList<String>();
        if (whereTotal <= 2) {
            if (selectedHome == false) {
                String suggestion = "Try selling at home";
                suggestionList.add(suggestion);
            }
            if (selectedNeighborhood == false) {
                String suggestion = "Try selling around your neighborhood";
                suggestionList.add(suggestion);
            }
            if (selectedCart == false) {
                String suggestion = "Try selling with a traveling cart";
                suggestionList.add(suggestion);
            }
            if (selectedStore == false) {
                String suggestion = "Try selling in a store";
                suggestionList.add(suggestion);
            }
        if (whoTotal <= 2) {
            if (selectedFamily == false) {
                String suggestion = "Try selling to your family";
                suggestionList.add(suggestion);
            }
            if (selectedFriends == false) {
                String suggestion = "Try selling to your friends";
                suggestionList.add(suggestion);
            }
            if (selectedNeighbors == false) {
                String suggestion = "Try selling to your neighbors";
                suggestionList.add(suggestion);
            }
            if (selectedPublic == false) {
                String suggestion = "Try selling to the public";
                suggestionList.add(suggestion);
            }
        }
        }
        Log.i("MyActivity", "suggestionList " + suggestionList);

        SharedPreferencesUtility.putStringList(this, "recommendation", suggestionList );
        suggestionList = SharedPreferencesUtility.getStringList(this, "recommendation");
        Log.i("MyActivity", "sharedPreferences " + suggestionList);

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
