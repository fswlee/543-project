

package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.content.Intent;
import android.view.View;

public class NewPlan extends Activity {
	
	

    //display textView1//
    //display button1//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);
    }

    //when user selects button1, load activity 2 (ClientInformation)//
    public void openActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ClientInformation.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_plan, menu);
        return true;
    }


}
