package com.edu.umich.businessplan.businessplan;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hannah Brookhart on 11/13/2014.
 */
public class SharedPreferencesUtility {



    public static List<String> getStringList(Activity activity, String key) {
        List<String> list = new ArrayList<String>(); //default list

// grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        Log.i("MyActivity", "Getting" + listString);//log line

        if(listString.length() != 0) {
// string.split will create an array returning everything in between the provided "delimiter"
// parameter
// example: if the string is hello;world;!, calling split(";") on it would return an array
// with 3 items: "hello", "world", and "!"
            String[] items = listString.split(";");
// loop through the array and add it to a list so we can give it back to the method caller
            for (String i : items) {
                list.add(i);
            }
        }
        Log.i("MyActivity", "Getting size " + list.size());
        return list;

    }


//This method saves a BusinessPlan object to SharedPreferences as a string:
//"Business Plan": "name;;city;;household;;income;;suggestion;suggestion;suggestion;;action;action;action"
    public static void putBusinessPlan(Activity activity, String key, BusinessPlan value) {
        //create a list with all values from BP
        String name = value.getName();
        String city = value.getCity();
        Integer household = value.getHousehold();
        Integer income = value.getIncome();
        List suggestions = value.getSuggestions();
        String suggestionsString = TextUtils.join(";", suggestions); //convert this list to a string delimited by ";"
        List actions = value.getActions();
        String actionsString = TextUtils.join(";", actions); //convert this list to a string delimited by ";"

        List<String> bpList = new ArrayList<String>(); //empty list to hold all BP attributes
        //add all BP attributes to the list
        bpList.add(";_;" + name);
        bpList.add(city);
        bpList.add(household.toString()); //convert int to string
        bpList.add(income.toString());
        bpList.add(suggestionsString);
        bpList.add(actionsString);

        //convert the BP list to a string delimited by ";;"
        String bpListString = TextUtils.join(";;", bpList);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, name); //Add the BP object to shared prefs
        //it looks like this:
        //"Business Plan": "name;;city;;household;;income;;suggestion;suggestion;suggestion;;action;action;action"
        editor.apply();


        Log.i("SharedPreferencesUtility", "What Does My BP look like? (debug) " + bpListString);
    }

    public static String getBusinessPlan(Activity activity, String key) {

        //List<String> list = new ArrayList<String>(); //default list

// grab the preferences associated with the activity passed into this method
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString("Business Plan", "");
        Log.i("MyActivity", "Getting BPList" + listString);//log line

//        if (listString.length() != 0) {
//// string.split will create an array returning everything in between the provided "delimiter"
//// parameter
//// example: if the string is hello;world;!, calling split(";") on it would return an array
//// with 3 items: "hello", "world", and "!"
//            String[] items = listString.split(";;");
//// loop through the array and add it to a list so we can give it back to the method caller
//            for (String i : items) {
//                list.add(i);
//            }
//        }
//        Log.i("MyActivity", "Getting size " + list.size());
//        Log.i("MyActivity", "return list" + list);//log line
        return listString;


    }

    public static String putStringList(Activity activity, String key, List<String> list) {
// for each string in the list, we want to add it to a new variable and separate the strings
// by putting semicolons in between them
// TextUtils.join takes a list or array of objects and places them into one string separated
// by the string in the first parameter (semicolon in this case)

        String listString = TextUtils.join(";", list);
// save the new combined string into preferences

//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString(key, listString);
//        editor.apply();

        return listString;
//        Log.i("MyActivity", "SharedPrefs: " + listString);
    }

    public static void clearSuggestionList(Activity activity, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();


        //for printing in console to see updated list (should be empty)
        List showList = SharedPreferencesUtility.getStringList(activity, key);
        Log.i("MyActivity", "SharedPrefs: " + showList);
    }

    public static void clearAll(Activity activity) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
