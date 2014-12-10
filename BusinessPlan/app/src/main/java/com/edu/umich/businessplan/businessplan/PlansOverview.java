package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlansOverview extends BaseActivity {

    //adapter used to display client names from previous Business Plans
    MyCustomAdapter dataAdapter = null;

    ArrayList<BusinessPlan> bpClassList = new ArrayList<BusinessPlan>(); //default list
    final Context context = this;

    //create Shared Preferences object
    SharedPreferences sharedpreferences;
    final String prename = "mypref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_overview);


        displayListView(getSharedPreferences());

    }

    public void displayListView(String string)  {
        String bpString = string;

        Log.i("PlansOverview", "initlist() string" + bpString);

        if (bpString.length() != 0) {
            String[] businessPlans = bpString.split(";_;");

            //loop through Business Plans
            for (String bp : businessPlans) {
                Log.i("PlansOverview", "bp" + bp);
                String[] bpAttributes = bp.split(";;");
                String name = bpAttributes[0];
                Log.i("PlansOverview", "name" + name);
                String city = bpAttributes[1];
                String actions = bpAttributes[2];

                BusinessPlan newBP = new BusinessPlan(name);
                newBP.setCity(city);
                newBP.addActions(actions);


                bpClassList.add(newBP);

            }

        }

        //create an ArrayAdaptar from the Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.activity_plans_overview, bpClassList );
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, save that business plan to SharedPreferences using keys "name", "city", "actions", and "new"
                BusinessPlan businessPlan = (BusinessPlan) parent.getItemAtPosition(position);
                String name = businessPlan.getName();
                String city = businessPlan.getCity();
                List actions = businessPlan.getActions();
                String actionsString = TextUtils.join(";", actions);

                SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                editor.putString("name", name);
                editor.putString("city", city);
                editor.putString("actions", actionsString);
                editor.putBoolean("new", false); //used to tell the ActionPlan activity not to resave this BusinessPlan to SP
                editor.apply();

                String debugName = mySharedPreferences.getString("name", "");
                Log.i("Plans Overview", "name" + debugName);

                String debugCity = mySharedPreferences.getString("city", "");
                Log.i("Plans Overview", "city" + debugCity);

                String debugActions = mySharedPreferences.getString("actions", "");
                Log.i("Plans Overview", "actions" + debugActions);

                Intent intent = new Intent(getApplicationContext(), ActionPlan.class);
                startActivity(intent);

                //DEBUGGING
                //Toast.makeText(getApplicationContext(),
                //        "Clicked on Row: " + suggestion.getName(),
                //        Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<BusinessPlan> {

        private ArrayList<BusinessPlan> bpList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<BusinessPlan> bpList) {
            super(context, textViewResourceId, bpList);
            this.bpList = new ArrayList<BusinessPlan>();
            this.bpList.addAll(bpList);
        }

        private class ViewHolder {
            TextView name;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.client_info, null);

                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.textView1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        TextView tv = (TextView) v ;
                        CharSequence actionCharSequence = tv.getText();
                        String name = actionCharSequence.toString();

                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            BusinessPlan businessPlan = bpList.get(position);
            holder.name.setText(businessPlan.getName());
//            holder.name.setChecked(businessPlan.isSelected());
//            holder.name.setTag(suggestion);

            return convertView;

        }

    }

    //gets business plans from SP with key "Business Plan"
    public String getSharedPreferences() {
        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        String returnString = mySharedPreferences.getString("Business Plan", "");
        Log.i("PlansOverview", "SP Business Plan " + returnString);

        return returnString; //string of business plans delimited with ";_;"
    }


//NAVIGATION
    //if user selects "close" the NewPlan activity opens
    public void goBack(View view) {
        Intent intent = new Intent(getApplicationContext(), NewPlan.class);
        startActivity(intent);

    }

//ACTIONBAR MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.plans_overview, menu);
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
