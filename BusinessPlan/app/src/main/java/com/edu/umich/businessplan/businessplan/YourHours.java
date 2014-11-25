//Hannah
//This is Activity 5
package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

//display textViews and Buttons upon activity instantiation

//if the user selects any, button change its state from unselected to selected. the user can select
//as many buttons as he or she wants

//if the user selects the back button an onClick event occurs

    //Activity4 (YourCustomers) loads

    //the algorithm that generates suggestions for improvement is updated to include the number
    //of buttons selected
        //determine how many weekend shifts
        //determine how many morning, afternoon, evening
    /*This is really complicated pseudo code to write
        //list_Morning{0,0,0,0,0,0,0}
        //list_Afternoon{0,0,0,0,0,0,0}
        //list_Evening{0,0,0,0,0,0,0}
        //if MonMorn=1
            //list_Morning(0)=1
        //if MonAfter=1
            list_Morning(0)=1
        if MonEvening=1
            list_Morning(0)=1
        if TuesMorn=1
            list_Morning(0)=1
        if TuesAfter=1
            list_Morning(0)=1
        if TuesEvening=1
            list_Morning(0)=1
        if WedMorn=1
            list_Morning(0)=1
        if WedAfter=1
            list_Morning(0)=1
        if WedEvening=1
            list_Morning(0)=1
        if ThurMorn=1
            list_Morning(0)=1
        if ThurAfter=1
            list_Morning(0)=1
        if ThurEvening=1
            list_Morning(0)=1
        if FriMorn=1
            list_Morning(0)=1
        if FriAfter=1
            list_Morning(0)=1
        if FriEvening=1
            list_Morning(0)=1
        if SatMorn=1
            list_Morning(0)=1
        if SatAfter=1
            list_Morning(0)=1
        if SatEvening=1
            list_Morning(0)=1
        if SunMorn=1
            list_Morning(0)=1
        if SunAfter=1
            list_Morning(0)=1
        if SunEvening=1
            list_Morning(0)=1*/


//if the user selects the forward button an onClick event occurs

    //Activity6 (HowIsBusiness) loads

    //the algorithm that generates suggestions for improvement is updated to include the number
    //of buttons selected
        //determine how many weekend shifts
        //determine how many morning, afternoon, evening shifts

public class YourHours extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_hours);

        calculateRecommendations();
    }

    //initialize selected status variables (bool)
    boolean selectedMondayMorning = false;
    boolean selectedTuesdayMorning = false;
    boolean selectedWednesdayMorning = false;
    boolean selectedThursdayMorning = false;
    boolean selectedFridayMorning = false;
    boolean selectedSaturdayMorning = false;
    boolean selectedSundayMorning = false;



    //initialize total variables (int)
    int weekdayTotal = 0;
    int weekendTotal = 9;
    int morningTotal = 0;
    int afternoonTotal = 0;
    int eveningTotal = 0;


    public void selectHours(View view) {
        //create variables for each button
        Button mondayMorning = (Button) findViewById(R.id.mondayMorning);
        Button tuesdayMorning = (Button) findViewById(R.id.mondayMorning);
        Button wednesdayMorning = (Button) findViewById(R.id.mondayMorning);
        Button thursdayMorning = (Button) findViewById(R.id.mondayMorning);
        Button fridayMorning = (Button) findViewById(R.id.mondayMorning);
        Button saturdayMorning = (Button) findViewById(R.id.mondayMorning);
        Button sundayMorning = (Button) findViewById(R.id.mondayMorning);

        //for each button
        //if it has already been selected
        //change the background color to black
        //change the selected variable to TRUE
        //if not, revert the color to original and change the selected variable to FALSE
        //depending on whether the variable is selected, add 1 or subtract 1 from the total
        //  number of buttons in each group (where or who)

        if (view.getId() == R.id.mondayMorning) {
            if (selectedMondayMorning == false) {
                mondayMorning.setBackgroundColor(Color.BLACK);
                selectedMondayMorning = true;
                weekdayTotal += 1;
                morningTotal += 1;
            } else {
                mondayMorning.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedMondayMorning = false;
                weekdayTotal -= 1;
                morningTotal -= 1;
            }
        }

        if (view.getId() == R.id.tuesdayMorning) {
            if (selectedTuesdayMorning == false) {
                tuesdayMorning.setBackgroundColor(Color.BLACK);
                selectedTuesdayMorning = true;
                weekdayTotal += 1;
                morningTotal += 1;
            } else {
                tuesdayMorning.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedTuesdayMorning = false;
                weekdayTotal -= 1;
                morningTotal -= 1;
            }
        }

        if (view.getId() == R.id.wednesdayMorning) {
            if (selectedWednesdayMorning == false) {
                wednesdayMorning.setBackgroundColor(Color.BLACK);
                selectedWednesdayMorning = true;
                weekdayTotal += 1;
                morningTotal += 1;
            } else {
                wednesdayMorning.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedWednesdayMorning = false;
                weekdayTotal -= 1;
                morningTotal -= 1;
            }
        }

        if (view.getId() == R.id.thursdayMorning) {
            if (selectedThursdayMorning == false) {
                thursdayMorning.setBackgroundColor(Color.BLACK);
                selectedThursdayMorning = true;
                weekdayTotal += 1;
                morningTotal += 1;
            } else {
                thursdayMorning.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedThursdayMorning = false;
                weekdayTotal -= 1;
                morningTotal -= 1;
            }
        }
        if (view.getId() == R.id.fridayMorning) {
            if (selectedFridayMorning == false) {
                fridayMorning.setBackgroundColor(Color.BLACK);
                selectedFridayMorning = true;
                weekdayTotal += 1;
                morningTotal += 1;
            } else {
                fridayMorning.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedFridayMorning = false;
                weekdayTotal -= 1;
                morningTotal -= 1;
            }
        }

        if (view.getId() == R.id.saturdayMorning) {
            if (selectedSaturdayMorning == false) {
                saturdayMorning.setBackgroundColor(Color.BLACK);
                selectedSaturdayMorning = true;
                weekendTotal += 1;
                morningTotal += 1;
            } else {
                saturdayMorning.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedSaturdayMorning = false;
                weekendTotal -= 1;
                morningTotal -= 1;
            }
        }

        if (view.getId() == R.id.sundayMorning) {
            if (selectedSundayMorning == false) {
                sundayMorning.setBackgroundColor(Color.BLACK);
                selectedSundayMorning = true;
                weekendTotal += 1;
                morningTotal += 1;
            } else {
                sundayMorning.setBackgroundColor(Color.rgb(45, 196, 137));
                selectedSundayMorning = false;
                weekendTotal -= 1;
                morningTotal -= 1;
            }
        }
    }

    public void calculateRecommendations() {
        List<String> suggestionList = new ArrayList<String>(); //empty list

        //if fewer than two buttons from the group are selected
        //add suggestions only if the button has not been selected
        if (weekdayTotal<= 3) {
            String suggestion = "Try selling more during the week";
            suggestionList.add(suggestion);
        }
        if (weekendTotal == 0) {
            String suggestion = "Try selling on the weekend";
            suggestionList.add(suggestion);
        }
        if (morningTotal <= 3) {
            String suggestion = "Try selling more during the morning";
            suggestionList.add(suggestion);
        }
        if (afternoonTotal <= 3) {
            String suggestion = "Try selling more during the afternoon";
            suggestionList.add(suggestion);
        }
        if (eveningTotal <= 3) {
            String suggestion = "Try selling more during the evening";
            suggestionList.add(suggestion);
        }




        Log.i("MyActivity", "suggestionList " + suggestionList);

        //add the suggestionList to the sharedPreferences using
        //  the method in the SharedPreferences Utility class
        //TODO grab shared prefs from previous screens in order to add these recommendations
        SharedPreferencesUtility.putStringList(this, "recommendation", suggestionList);
        //use the lines below to test whether the correct suggestions were added
        suggestionList = SharedPreferencesUtility.getStringList(this, "recommendation");
        Log.i("MyActivity", "sharedPreferences " + suggestionList);

    }


    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YourCustomers.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HowIsBusiness.class);
        startActivity(intent);
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
