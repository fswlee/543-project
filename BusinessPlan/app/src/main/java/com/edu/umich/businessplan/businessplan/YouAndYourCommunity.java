// Florence Lee
//This is Activity7

package com.edu.umich.businessplan.businessplan;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;


import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;


// household
// over18
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

    private final Handler mHandler = new Handler();
    private Runnable mTimer1;
    private Runnable mTimer2;
    private GraphView graphView;
    private GraphViewSeries exampleSeries1;
    private GraphViewSeries exampleSeries2;
    private double graph2LastXValue = 5d;
    private GraphViewSeries exampleSeries3;

    //change graphType to line if bar chart not required
    private String graphType = "bar";

    private double getRandom() {
        double high = 3;
        double low = 0.5;
        return Math.random() * (high - low) + low;
    }

    // grab # of people from sharedpreferences
    // threshold list
    1,11888;2,15142

    // grab income from sharedpreferences
    // multiply by 12 and plot

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_and_your_community);


        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] {
                new GraphViewData(1, 2.0d)
//                , new GraphViewData(2, 1.5d)
                , new GraphViewData(3, 4d)
        });

        GraphView graphView = new BarGraphView(
                this // context
                , "GraphViewDemo" // heading
        );
        graphView.addSeries(exampleSeries); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.graph2);
        layout.addView(graphView);

        // Set bar labels
        graphView.setHorizontalLabels(new String[] {"you", "your community"});
        graphView.setManualYAxisBounds(40,0);


    }



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
