package com.montoya.gabi.scorecard.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.montoya.gabi.scorecard.R;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardUtils {

    public static final String APP_LOG_TAG="SCARD";


    public static final int PREFERENCES_INVALID_INT=-1;




    public static int getConvertedLength (Context context,int currentLengthInMeters){

        //TODO Convertion - search the preferences and if it is yards perform the converion

        return currentLengthInMeters;
    }



    public static String getFormattedCurrentLengthUnit(Context context){

        //TODO Find the selected length unit an return the corresponding String
        return context.getString(R.string.settings_meters_description);
    }


    public static String getFormattedLength (Context context,int currentLengthInMeters){

        int convertedLength=getConvertedLength(context,currentLengthInMeters);

        //TODO find the selected length unit and format the String correctly (if meter .... else ....)

        return String.format(context.getString(R.string.formatted_meters_length),convertedLength);


    }


    public static String getFormattedPar (Context context, int par){
        return String.format(context.getString(R.string.formatted_par),par);
    }



    public static void AddIntToSharedPreferences(Context context,String key, int value){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit= preferences.edit();
        edit.putInt(key,value);
        edit.apply();


    }


    public static int RetrieveIntFromSharedPreferences(Context context,String key){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key,PREFERENCES_INVALID_INT);

    }


    public static void RemoveKeyFromSharedPreferences (Context context,String key){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit= preferences.edit();
        edit.remove(key);
        edit.apply();


    }



}
