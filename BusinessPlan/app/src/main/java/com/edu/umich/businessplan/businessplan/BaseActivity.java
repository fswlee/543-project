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



            default:
                return super.onOptionsItemSelected(item);

        }}
    }
