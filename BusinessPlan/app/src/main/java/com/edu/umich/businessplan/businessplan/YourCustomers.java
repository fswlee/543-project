//Activity 4 (Your Customers)

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_customers);

        //clear the suggestion list from shared preferences
        SharedPreferencesUtility.clearSuggestionList(this, "recommendation");

        //call method to add suggestions to sharedPreferences
        //if the user gets to this page, but selects nothing, all eight suggestions
        //should be added to the sharedPreferences
        calculateRecommendations();

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
        //create variables for each button
        ImageButton sell_home = (ImageButton) findViewById(R.id.buttonHome);
        ImageButton sell_neighborhood = (ImageButton) findViewById(R.id.buttonNeighborhood);
        ImageButton sell_cart = (ImageButton) findViewById(R.id.buttonCart);
        ImageButton sell_store = (ImageButton) findViewById(R.id.buttonStore);

        ImageButton sellto_family = (ImageButton) findViewById(R.id.buttonFamily);
        ImageButton sellto_friends = (ImageButton) findViewById(R.id.buttonFriends);
        ImageButton sellto_neighbors = (ImageButton) findViewById(R.id.buttonNeighbors);
        ImageButton sellto_public = (ImageButton) findViewById(R.id.buttonPublic);

        //for each button
            //if it has already been selected
                //change the background color to black
                //change the selected variable to TRUE
            //if not, revert the color to original and change the selected variable to FALSE
            //depending on whether the variable is selected, add 1 or subtract 1 from the total
            //  number of buttons in each group (where or who)

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

        else if (view.getId() == R.id.buttonFamily) {
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
            Log.i("MyActivity", "Who Total " + whoTotal);
            Log.i("MyActivity", "Public? " + selectedPublic);
        }
        Log.i("MyActivity", "Who Total: " + whoTotal);
        Log.i("MyActivity", "Where Total: " + whereTotal);

        //call the calculateRecommendations method to update the sharedPreferences
        calculateRecommendations();
    }


    public void calculateRecommendations() {
        List<String> suggestionList = new ArrayList<String>(); //empty list

        //if fewer than two buttons from the group are selected
            //add suggestions only if the button has not been selected
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
            }}
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

            Log.i("MyActivity", "suggestionList " + suggestionList);

            //add the suggestionList to the sharedPreferences using
            //  the method in the SharedPreferences Utility class
            SharedPreferencesUtility.putStringList(this, "recommendation", suggestionList);
            //use the lines below to test whether the correct suggestions were added
            suggestionList = SharedPreferencesUtility.getStringList(this, "recommendation");
            Log.i("MyActivity", "sharedPreferences " + suggestionList);

    }

//Navigation
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

//Actionbar menu
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
