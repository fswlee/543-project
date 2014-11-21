//This is Activity6

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class HowIsBusiness extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_is_business);
    }

    public void selectButton (View view) {
        ImageButton superhappy = (ImageButton) findViewById(R.id.superhappy);
        ImageButton happy = (ImageButton) findViewById(R.id.happy);
        ImageButton meh = (ImageButton) findViewById(R.id.meh);
        ImageButton sad = (ImageButton) findViewById(R.id.sad);
        ImageButton supersad = (ImageButton) findViewById(R.id.supersad);


        //if a button is selected
        //  that button's background color changes
        //  the other buttons' background color change to their original color

        if(view.getId() == R.id.superhappy){
            superhappy.setBackgroundColor(Color.BLACK);
            happy.setBackgroundColor(Color.rgb(45,196,137));
            meh.setBackgroundColor(Color.rgb(45, 196, 137));
            sad.setBackgroundColor(Color.rgb(45,196,137));
            supersad.setBackgroundColor(Color.rgb(45, 196, 137));
        }

        else if (view.getId() == R.id.happy){
            happy.setBackgroundColor(Color.BLACK);
            superhappy.setBackgroundColor(Color.rgb(45,196,137));
            meh.setBackgroundColor(Color.rgb(45,196,137));
            sad.setBackgroundColor(Color.rgb(45,196,137));
            supersad.setBackgroundColor(Color.rgb(45,196,137));
        }
        else if (view.getId() == R.id.meh){
            meh.setBackgroundColor(Color.BLACK);
            happy.setBackgroundColor(Color.rgb(45,196,137));
            superhappy.setBackgroundColor(Color.rgb(45, 196, 137));
            sad.setBackgroundColor(Color.rgb(45,196,137));
            supersad.setBackgroundColor(Color.rgb(45,196,137));
        }
        else if (view.getId() == R.id.sad) {
            sad.setBackgroundColor(Color.BLACK);
            happy.setBackgroundColor(Color.rgb(45, 196, 137));
            meh.setBackgroundColor(Color.rgb(45, 196, 137));
            superhappy.setBackgroundColor(Color.rgb(45, 196, 137));
            supersad.setBackgroundColor(Color.rgb(45, 196, 137));
        }
        else if (view.getId() == R.id.supersad) {
            supersad.setBackgroundColor(Color.BLACK);
            happy.setBackgroundColor(Color.rgb(45, 196, 137));
            meh.setBackgroundColor(Color.rgb(45, 196, 137));
            sad.setBackgroundColor(Color.rgb(45, 196, 137));
            superhappy.setBackgroundColor(Color.rgb(45, 196, 137));
        }

    }

    //onClick of back button
    public void openPreviousActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YourHours.class);
        startActivity(intent);
    }

    //onClick of forward button
    public void openNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), YouAndYourCommunity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.how_is_business, menu);
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
