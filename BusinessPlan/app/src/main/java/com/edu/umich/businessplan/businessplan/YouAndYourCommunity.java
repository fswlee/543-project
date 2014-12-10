// Florence Lee
//This is Activity7

package com.edu.umich.businessplan.businessplan;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.widget.Toast;
import java.util.*;


import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;


// create new variable annual_income by muliplying income_per_month by 12.

// display the main menu button.
	// display the name of the page.
	// display textview1 and textview3

	// display Graph using GraphView library?
	//
	//
	//
	// The first bar will display the value of the average poverty
    // in an urban, rural, or suburban area, depending on what is stored
    // in the location variable.

        // If location == rural, display average rural poverty
        // If location == suburban, display average suburban poverty
        // If location == urban, display average urban poverty

    // The value of the second bar will be the value from the income variable.

	// When the user selects "button1" (next), an onClick event
	// is triggered. Load the previous activity (HowIsBusiness).
	
	// When the user selects "button2" (previous), an onClick event
	// is triggered. Load the next activity (SuggestionsForImprovement).



public class YouAndYourCommunity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_and_your_community);

        // graph created using the GraphView library
        // http://android-graphview.org/#doc_howto
        // based on http://karanbalkar.com/2014/05/display-graphs-using-graphview-in-android/


        //create a variable of type SharedPreferences:
        SharedPreferences sharedpreferences;
        String prename="mypref";

        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        int num_people = mySharedPreferences.getInt("household",0);
        int income = mySharedPreferences.getInt("income",0);

        // calculate annual income for the graph
        int annual_income = income * 12;

        // initialize poverty threshold variable
        int poverty_threshold = 0;

        // set value of poverty_threshold depending on the number of people
        if (num_people == 1) {
            poverty_threshold = 11888;
        }
        else if (num_people == 2) {
            poverty_threshold = 15142;
        }
        else if (num_people == 3) {
            poverty_threshold = 18552;
        }
        else if (num_people == 4) {
            poverty_threshold = 23824;
        }
        else if (num_people == 5) {
            poverty_threshold = 28265;
        }
        else if (num_people == 6) {
            poverty_threshold = 31925;
        }
        else if (num_people == 7) {
            poverty_threshold = 36384;
        }
        else if (num_people == 8) {
            poverty_threshold = 40484;
        }
        else if (num_people == 9) {
            poverty_threshold = 48065;
        }

//        // for debugging
//        Toast.makeText(this, "number of people " + num_people + "," + "income " + annual_income + ", threshold " + poverty_threshold, Toast.LENGTH_LONG).show();

        // values for the graph
        GraphViewSeries graphValues = new GraphViewSeries(new GraphViewData[] {
                new GraphViewData(1, annual_income)
              , new GraphViewData(3, poverty_threshold)
        });

        GraphView graphView = new BarGraphView(
                this // context
                , "Annual Income" // heading
        );
        graphView.addSeries(graphValues); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);

        // Set bar labels
        graphView.setHorizontalLabels(new String[] {"You", "Your Community"});
        graphView.setManualYAxisBounds(60000,0); // Y axis bound



    }


//NAVIGATION
    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), HowIsBusiness.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), SuggestionsForImprovement.class);
        startActivity(intent);
    }

//ACTIONBAR MENU
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
