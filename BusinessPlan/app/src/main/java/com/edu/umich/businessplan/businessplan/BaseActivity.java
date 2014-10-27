package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



public class BaseActivity extends Activity {

    private final String TAG = "Base Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    public void openCreateNewPlan() {
        Intent intent = new Intent(getApplicationContext(), NewPlan.class);
        startActivity(intent);
    }

    public void openClientInformation() {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);
    }

    public void openBusinessInformation() {
        Intent intent = new Intent(getApplicationContext(), BusinessInformation.class);
        startActivity(intent);
    }

    public void openYourCustomers() {
        Intent intent = new Intent(getApplication(), YourCustomers.class);
        startActivity(intent);
    }

    public void openYourHours() {
        Intent intent = new Intent(getApplication(), YourHours.class);
        startActivity(intent);
    }

    public void openHowIsBusiness() {
        Intent intent = new Intent(getApplication(), HowIsBusiness.class);
        startActivity(intent);
    }

    public void openYouAndYourCommunity() {
        Intent intent = new Intent(getApplication(), YouAndYourCommunity.class);
        startActivity(intent);
    }

    public void openSuggestionsForImprovement() {
        Intent intent = new Intent(getApplication(), SuggestionsForImprovement.class);
        startActivity(intent);
    }

    public void openActionPlan() {
        Intent intent = new Intent(getApplication(), ActionPlan.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case R.id.create_new_plan:
                Log.i(TAG, "create_new_plan Item clicked");
                openCreateNewPlan();
                return true;

            case R.id.client_information:
                Log.i(TAG, "client_information Item Clicked");
                openClientInformation();
                return true;

            case R.id.business_information:
                Log.i(TAG, "business_information Item Clicked");
                openBusinessInformation();
                return true;

            case R.id.your_customers:
                Log.i(TAG, "your_customers Item Clicked");
                openYourCustomers();
                return true;

            case R.id.your_hours:
                Log.i(TAG, "your_hours Item Clicked");
                openYourHours();
                return true;

            case R.id.how_is_business:
                Log.i(TAG, "how_is_business Item Clicked");
                openHowIsBusiness();
                return true;

            case R.id.you_and_your_community:
                Log.i(TAG, "you_and_your_community Item Clicked");
                openYouAndYourCommunity();
                return true;

            case R.id.suggestions_for_improvement:
                Log.i(TAG, "suggestions_for_improvement Item Clicked");
                openSuggestionsForImprovement();
                return true;

            case R.id.action_plan:
                Log.i(TAG, "action_plan Item Clicked");
                openActionPlan();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }}
    }
