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

    // the string variable we use for sending messages with intents
    public final static String EXTRA_MESSAGE = "edu.umich.teamivore.MESSAGE";

    MyCustomAdapter dataAdapter = null;

    //List<Map<String, String>> clientList = new ArrayList<Map<String,String>>();
   // List<BusinessPlan> clientList = new ArrayList<BusinessPlan>();
    ArrayList<BusinessPlan> bpClassList = new ArrayList<BusinessPlan>(); //default list
    final Context context = this;

    //create Shared Preferences object
    SharedPreferences sharedpreferences;
    final String prename = "mypref";

    String bpListString = "";
    List bpList = new ArrayList<List>();
    String bpClientName = ""; //name
    String bpClientListString = "";
    List bpClientList = new ArrayList<List>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_overview);


        //bpListString = getSharedPreferences();
        // we call this initiList function to fill in our list class variable with our team names

        //initList(bpListString);

        displayListView(getSharedPreferences());

    }

    public void displayListView(String string)  {
//        List<BusinessPlan> bpClassList = new ArrayList<BusinessPlan>(); //default list
        String bpString = string;

        Log.i("PlansOverview", "initlist() string" + bpString);
//        List<String> clientList2 = SharedPreferencesUtility.getStringList(this, "client");
//        Log.i("MyActivity", "What The Hell is Happening: " + clientList2);
//        for(String t: clientList2) {
//            clientList.add(createClient("client", t));
//        }
        //takes a string of suggestions delimited by ";" and returns a List of suggestions



        if (bpString.length() != 0) {
            String[] businessPlans = bpString.split(";_;");
// loop through teams
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


                //add the instance to the array list, suggestionList
                bpClassList.add(newBP);


                //Team newTeam = new Team(name, description);
                //clientList.add(createClient("client", newBP));
            }
            //Log.i("PlansOverview", "bpList" + list);
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
                // When clicked, show a toast with the TextView text
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
                editor.putBoolean("new", false);
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




//                        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = mySharedPreferences.edit();
//
//                        editor.putString("name", name);


//                        String debugName = mySharedPreferences.getString("name", "");
//                        Log.i("Plans Overview", "name" + debugName);



                        //Suggestion suggestion= (Suggestion) tv.getTag();
                        //if (cb.isChecked()== true) {
                            //selectedCount += 1;
                            //addAction(action);

                        //}
                        //else {
                            //selectedCount -= 1;
                            //removeAction(action);
                        //}

                        //Log.i("MyActivity", "sharedPreferences " + action);

                        //DEBUGGING toast
                        //Toast.makeText(getApplicationContext(),
                        //        "Clicked on Checkbox: " + cb.getText() +
                        //                " is " + cb.isChecked(),
                        //        Toast.LENGTH_LONG).show();
                        //suggestion.setSelected(cb.isChecked());
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

//
//
//
//
//        //create an ArrayAdaptar from the Array
//        dataAdapter = new MyCustomAdapter(this,
//                R.layout.activity_plans_overview, clientList);
//        ListView listView = (ListView) findViewById(R.id.listView1);
//        // Assign adapter to ListView
//        listView.setAdapter(dataAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // When clicked, show a toast with the TextView text
//                Suggestion suggestion = (Suggestion) parent.getItemAtPosition(position);
//
//                //DEBUGGING
//                //Toast.makeText(getApplicationContext(),
//                //        "Clicked on Row: " + suggestion.getName(),
//                //        Toast.LENGTH_LONG).show();
//            }
//        });
//
//        private class MyCustomAdapter extends ArrayAdapter<Suggestion> {
//
//            private ArrayList<Suggestion> suggestionList;
//
//            public MyCustomAdapter(Context context, int textViewResourceId,
//                                   ArrayList<BusinessPlan> clientList) {
//                super(context, textViewResourceId, clientList);
//                this.clientList = new ArrayList<Suggestion>();
//                this.clientList.addAll(clientList);
//            }
//
//
//        }
//
    public String getSharedPreferences() {
        // save values into sharedpreferences
        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();

        String returnString = mySharedPreferences.getString("Business Plan", "");
        Log.i("PlansOverview", "SP Business Plan " + returnString);

        return returnString;
    }
//
//
//
//// adapters are what we use to associate the list variable and its contents with the list view
//        ListView clientListView = (ListView) findViewById(R.id.listView1);
//        SimpleAdapter mySimpleAdapter = new SimpleAdapter(this, clientList, android.R.layout.simple_list_item_1, new String[] {"client"}, new int[] {android.R.id.text1});
//        clientListView.setAdapter(mySimpleAdapter);
//
//        // setOnItemClickListener tells the activity what to do when a list item is clicked on
//        clientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // When clicked, show a toast with the TextView text
//                List<Map<String, String>> businessPlan = new ArrayList<Map<String,String>
//                BusinessPlan businessPlan = (BusinessPlan) parent.getItemAtPosition(position);
//
//                String spName = businessPlan.getName();
//                String spCity = businessPlan.getCity();
//                List spActions = businessPlan.getActions();
//
//                String spActionsString = TextUtils.join(";", spActions);
//
//                SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
//                SharedPreferences.Editor editor = mySharedPreferences.edit();
//
//                editor.putString("name", spName);
//                editor.putString("city", spCity);
//                editor.putString("actions", spActionsString);
//                editor.apply();
//
//            }
//        });
//
//        private class MyCustomAdapter extends ArrayAdapter<Suggestion> {
//
//            private ArrayList<Suggestion> suggestionList;
//
//            public MyCustomAdapter(Context context, int textViewResourceId,
//                                   ArrayList<BusinessPlan> clientList) {
//                super(context, textViewResourceId, clientList);
//                this.clientList = new ArrayList<Suggestion>();
//                this.clientList.addAll(clientList);
//            }
//
//
//
//
//
//
//
//    // initList simply adds our team names to the list variable
//// in a real app, this would be where we query our database to retrieve the list of teams, but
//// we can perform some shared preferences data storing for now
//
//    public String getSharedPreferences() {
//        // save values into sharedpreferences
//        SharedPreferences mySharedPreferences = getSharedPreferences(prename, Activity.MODE_PRIVATE);
//        SharedPreferences.Editor editor = mySharedPreferences.edit();
//
//        String returnString = mySharedPreferences.getString("Business Plan", "");
//        Log.i("PlansOverview", "SP Business Plan " + returnString);
//
//        return returnString;
//    }
//
//    public void initList(String businessPlanString) {
//        String bpString = businessPlanString;
//        Log.i("PlansOverview", "initlist() string" + bpString);
////        List<String> clientList2 = SharedPreferencesUtility.getStringList(this, "client");
////        Log.i("MyActivity", "What The Hell is Happening: " + clientList2);
////        for(String t: clientList2) {
////            clientList.add(createClient("client", t));
////        }
//        //takes a string of suggestions delimited by ";" and returns a List of suggestions
//        List<BusinessPlan> bps = new ArrayList<BusinessPlan>(); //default list
//
//
//        if (bpString.length() != 0) {
//            String[] businessPlans = bpString.split(";_;");
//// loop through teams
//            for (String bp : businessPlans) {
//                Log.i("PlansOverview", "bp" + bp);
//                String[] bpAttributes = bp.split(";;");
//                String name = bpAttributes[0];
//                Log.i("PlansOverview", "name" + name);
//                String city = bpAttributes[1];
//                String actions = bpAttributes[2];
//
//                BusinessPlan newBP = new BusinessPlan(name);
//                newBP.setCity(city);
//                newBP.addActions(actions);
//
//                //Team newTeam = new Team(name, description);
//                clientList.add(createClient("client", newBP));
//            }
//            //Log.i("PlansOverview", "bpList" + list);
//        }
//    }
//
//
//
//
//
//    // this method helps us minimize the amount of repeat calls we need to make in initList to place
////a team name into out list
//    private HashMap<String, String> createClient(String key, BusinessPlan t) {
//        HashMap<String, String> client = new HashMap<String, String>();
//        String name = t.getName();
//        client.put(key, name);
//        return client;
//    }

    public void goToSummary(View view) {

    }

    //if user selects "close" the NewPlan activity opens
    //when user selects button1, load activity 2 (ClientInformation)//
    public void goBack(View view) {
        Intent intent = new Intent(getApplicationContext(), NewPlan.class);
        startActivity(intent);

    }

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
