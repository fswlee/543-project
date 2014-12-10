//This is Activity 5
// Apologies that the code is so repetitive and long -
//  I have been unable to implement a gridAdapter
package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class YourHours extends BaseActivity {

    List bpSuggestions = new ArrayList<Suggestion>(); //initially an empty list
    String currentSuggestionString = "";
    String prename = "mypref";

    //initialize total variables (int)
    int weekdayTotal = 0;
    int weekendTotal = 0;
    int morningTotal = 0;
    int afternoonTotal = 0;
    int eveningTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_hours);


        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        currentSuggestionString = mySharedPreferences.getString("suggestions", "");
        Log.i("YourHours", "getting current suggestionList: " + currentSuggestionString);


//        calculateRecommendations();
    }

    //initialize selected status variables (bool)
    //morning
    boolean selectedMondayMorning = false;
    boolean selectedTuesdayMorning = false;
    boolean selectedWednesdayMorning = false;
    boolean selectedThursdayMorning = false;
    boolean selectedFridayMorning = false;
    boolean selectedSaturdayMorning = false;
    boolean selectedSundayMorning = false;

    //afternoon
    boolean selectedMondayAfternoon = false;
    boolean selectedTuesdayAfternoon = false;
    boolean selectedWednesdayAfternoon = false;
    boolean selectedThursdayAfternoon = false;
    boolean selectedFridayAfternoon = false;
    boolean selectedSaturdayAfternoon = false;
    boolean selectedSundayAfternoon = false;

    //evening
    boolean selectedMondayEvening = false;
    boolean selectedTuesdayEvening = false;
    boolean selectedWednesdayEvening = false;
    boolean selectedThursdayEvening= false;
    boolean selectedFridayEvening = false;
    boolean selectedSaturdayEvening = false;
    boolean selectedSundayEvening = false;


//    //initialize total variables (int)
//    int weekdayTotal = 0;
//    int weekendTotal = 0;
//    int morningTotal = 0;
//    int afternoonTotal = 0;
//    int eveningTotal = 0;

    //receives the buttonID, the current selection status of the button, a string representing
    //  the weekday or weekend, and a string representing morning, afternoon, or evening
    //returns a the new selection status (boolean)
    private Boolean select(View buttonID, boolean inSelectedDayTime, String day, String time ) {
        boolean outSelectedDayTime;

        //for each button
        //if it has already been selected
        //change the background color to black
        //change the selected variable to TRUE
        //if not, revert the color to original and change the selected variable to FALSE
        //depending on whether the variable is selected, add 1 or subtract 1 from the total
        //  number of buttons in each group (weekday/weekend and morning/afternoon/evening)
        if (inSelectedDayTime == false) {
            outSelectedDayTime = true;
            if (day == "weekday") {
                weekdayTotal += 1;
            }
            else {
                weekendTotal += 1;
            }
            if (time == "morning") {
                morningTotal += 1;
            }
            else if (time == "afternoon") {
                afternoonTotal += 1;
            }
            else {
                eveningTotal += 1;
            }
            buttonID.setBackgroundColor(Color.BLACK);
        }
        else {
            outSelectedDayTime = false;
            if (day == "weekday") {
                weekdayTotal -= 1;
            }
            else {
                weekendTotal -= 1;
            }
            if (time == "morning") {
                morningTotal -= 1;
                Log.i("YourHours", "morning total " + morningTotal);
            }
            else if (time == "afternoon") {
                afternoonTotal -= 1;
            }
            else {
                eveningTotal += 1;
            }
            buttonID.setBackgroundColor(Color.rgb(45, 196, 137));
        }
        Log.i("YourHours Activity", "return value (selected - true or false) " +
                outSelectedDayTime );
        return outSelectedDayTime;

    }

    //receives a button view and is called when that button is clicked on
    //calls select() to change the background color, and add/subtract to the "total" variables
    public void selectHours(View view) {
        //create variables for each button
        Button mondayMorning = (Button) findViewById(R.id.mondayMorning);
        Button tuesdayMorning = (Button) findViewById(R.id.tuesdayMorning);
        Button wednesdayMorning = (Button) findViewById(R.id.wednesdayMorning);
        Button thursdayMorning = (Button) findViewById(R.id.thursdayMorning);
        Button fridayMorning = (Button) findViewById(R.id.fridayMorning);
        Button saturdayMorning = (Button) findViewById(R.id.saturdayMorning);
        Button sundayMorning = (Button) findViewById(R.id.sundayMorning);
        Button mondayAfternoon = (Button) findViewById(R.id.mondayAfternoon);
        Button tuesdayAfternoon = (Button) findViewById(R.id.tuesdayAfternoon);
        Button wednesdayAfternoon = (Button) findViewById(R.id.wednesdayAfternoon);
        Button thursdayAfternoon = (Button) findViewById(R.id.thursdayAfternoon);
        Button fridayAfternoon = (Button) findViewById(R.id.fridayAfternoon);
        Button saturdayAfternoon = (Button) findViewById(R.id.saturdayAfternoon);
        Button sundayAfternoon = (Button) findViewById(R.id.sundayAfternoon);
        Button mondayEvening = (Button) findViewById(R.id.mondayEvening);
        Button tuesdayEvening = (Button) findViewById(R.id.tuesdayEvening);
        Button wednesdayEvening = (Button) findViewById(R.id.wednesdayEvening);
        Button thursdayEvening = (Button) findViewById(R.id.thursdayEvening);
        Button fridayEvening = (Button) findViewById(R.id.fridayEvening);
        Button saturdayEvening = (Button) findViewById(R.id.saturdayEvening);
        Button sundayEvening = (Button) findViewById(R.id.sundayEvening);

        //morning
        if (view.getId() == R.id.mondayMorning) {
            String day = "weekday";
            String time = "morning";
            Log.i("YourHours", "Monday Morning selected");
            selectedMondayMorning = select(mondayMorning, selectedMondayMorning, day, time);
        }
        else if (view.getId() == R.id.tuesdayMorning) {
            String day = "weekday";
            String time = "morning";
            selectedTuesdayMorning = select(tuesdayMorning, selectedTuesdayMorning, day, time);
        }
        else if (view.getId() == R.id.wednesdayMorning) {
            String day = "weekday";
            String time = "morning";
            selectedWednesdayMorning = select(wednesdayMorning, selectedWednesdayMorning, day, time);
        }
        else if (view.getId() == R.id.thursdayMorning) {
            String day = "weekday";
            String time = "morning";
            selectedThursdayMorning = select(thursdayMorning, selectedThursdayMorning, day, time);
        }
        else if (view.getId() == R.id.fridayMorning) {
            String day = "weekday";
            String time = "morning";
            selectedFridayMorning = select(fridayMorning, selectedFridayMorning, day, time);
        }
        else if (view.getId() == R.id.saturdayMorning) {
            String day = "weekend";
            String time = "morning";
            selectedSaturdayMorning = select(saturdayMorning, selectedSaturdayMorning, day, time);
        }
        else if (view.getId() == R.id.sundayMorning) {
            String day = "weekend";
            String time = "morning";
            selectedSundayMorning = select(sundayMorning, selectedSundayMorning, day, time);
        }
        //afternoon
        else if (view.getId() == R.id.mondayAfternoon) {
            String day = "weekday";
            String time = "afternoon";
            selectedMondayAfternoon = select(mondayAfternoon, selectedMondayAfternoon, day, time);
        }
        else if (view.getId() == R.id.tuesdayAfternoon) {
            String day = "weekday";
            String time = "afternoon";
            selectedTuesdayAfternoon = select(tuesdayAfternoon, selectedTuesdayAfternoon, day, time);
        }
        else if (view.getId() == R.id.wednesdayAfternoon) {
            String day = "weekday";
            String time = "afternoon";
            selectedWednesdayAfternoon = select(wednesdayAfternoon, selectedWednesdayAfternoon, day, time);
        }
        else if (view.getId() == R.id.thursdayAfternoon) {
            String day = "weekday";
            String time = "afternoon";
            selectedThursdayAfternoon = select(thursdayAfternoon, selectedThursdayAfternoon, day, time);
        }
        else if (view.getId() == R.id.fridayAfternoon) {
            String day = "weekday";
            String time = "afternoon";
            selectedFridayAfternoon = select(fridayAfternoon, selectedFridayAfternoon, day, time);
        }
        else if (view.getId() == R.id.saturdayAfternoon) {
            String day = "weekend";
            String time = "afternoon";
            selectedSaturdayAfternoon = select(saturdayAfternoon, selectedSaturdayAfternoon, day, time);
        }
        else if (view.getId() == R.id.sundayAfternoon) {
            String day = "weekend";
            String time = "afternoon";
            selectedSundayAfternoon = select(sundayAfternoon, selectedSundayAfternoon, day, time);
        }
        //evening
        else if (view.getId() == R.id.mondayEvening) {
            String day = "weekday";
            String time = "evening";
            selectedMondayEvening = select(mondayEvening, selectedMondayEvening, day, time);
        }
        else if (view.getId() == R.id.tuesdayEvening) {
            String day = "weekday";
            String time = "evening";
            selectedTuesdayEvening = select(tuesdayEvening, selectedTuesdayEvening, day, time);
        }
        else if (view.getId() == R.id.wednesdayEvening) {
            String day = "weekday";
            String time = "evening";
            selectedWednesdayEvening = select(wednesdayEvening, selectedWednesdayEvening, day, time);
        }
        else if (view.getId() == R.id.thursdayEvening) {
            String day = "weekday";
            String time = "evening";
            selectedThursdayEvening = select(thursdayEvening, selectedThursdayEvening, day, time);
        }
        else if (view.getId() == R.id.fridayEvening) {
            String day = "weekday";
            String time = "evening";
            selectedFridayEvening = select(fridayEvening, selectedFridayEvening, day, time);
        }
        else if (view.getId() == R.id.saturdayEvening) {
            String day = "weekend";
            String time = "evening";
            selectedSaturdayEvening = select(saturdayEvening, selectedSaturdayEvening, day, time);
        }
        else if (view.getId() == R.id.sundayEvening) {
            String day = "weekend";
            String time = "evening";
            selectedSundayEvening = select(sundayEvening, selectedSundayEvening, day, time);
        }
    }

    public void calculateRecommendations() {
        //get the current list of recommendations from shared preferences
        List<String> suggestionList = new ArrayList<String>(); //empty list
        //suggestionList = SharedPreferencesUtility.getStringList(this, "recommendation");

        //if the condition is met, add the suggestion to the suggestionList
        if (weekdayTotal<= 7) {
            String suggestion = "Try selling more during the week";
            suggestionList.add(suggestion);
        }
        if (weekendTotal <= 3) {
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

        bpSuggestions = suggestionList;

        Log.i("YourHours", "getting suggestionList: " + bpSuggestions);

//        //save the new list of suggestions to shared preferences
//        SharedPreferencesUtility.putStringList(this, "recommendation", suggestionList);
//
//        //DEBUGGING: use the lines below to test whether the correct suggestions were added
//        suggestionList = SharedPreferencesUtility.getStringList(this, "recommendation");
//        Log.i("MyActivity", "sharedPreferences " + suggestionList);

    }

    public void addSharedPreferences(List suggestionList) {

        String suggestionStringList = stringListUtility(suggestionList);

        //concatenate the string of suggestions already saved in SP (saved in YourCustomers)
        //with the string of suggestions generated during this activity

        String combinedSuggestionStringList = currentSuggestionString + suggestionStringList;

        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        editor.putString("suggestions", combinedSuggestionStringList);
        editor.apply();

        String debugSuggestions = mySharedPreferences.getString("suggestions", "");
        Log.i("YourHours", "SP suggestions: " + debugSuggestions);

        //check complete SharedPreferences
        Log.i("YourHours", "SP ALL: " + mySharedPreferences.getAll());

    }

    public String stringListUtility(List list) {
        //takes in a List and returns a string with list items delimited by a ";"
        String listString = TextUtils.join(";", list);
        listString = ";" + listString;


        return listString;
    }

//NAVIGATION
    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YourCustomers.class);
        calculateRecommendations();
        addSharedPreferences(bpSuggestions);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HowIsBusiness.class);
        calculateRecommendations();
        addSharedPreferences(bpSuggestions);
        startActivity(intent);
    }

//ACTIONBAR MENU
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
