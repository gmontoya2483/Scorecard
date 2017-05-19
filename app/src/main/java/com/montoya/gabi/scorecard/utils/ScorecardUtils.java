package com.montoya.gabi.scorecard.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.EditText;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.Hole;

/**
 * Created by montoya on 10.04.2017.
 */

public class ScorecardUtils {

    public static final String APP_LOG_TAG="SCARD";
    public static final double YARDS_PER_METERS=1.09361;


    public static final int PREFERENCES_INVALID_INT=-1;

    public static final String SHARED_UNIT_LENGTH_KEY="unit_length_key";
    public static final String SHARED_UNIT_LENGTH_METERS="unit_length_meters";
    public static final String SHARED_UNIT_LENGTH_YARDS="unit_length_yards";
    public static final String SHARED_UNIT_LENGTH_DEFAULT=SHARED_UNIT_LENGTH_YARDS;





    //this method receives a length in Meters, check the Current length unit and it returns the same value in if the Setting is in Meter or the value converted to yards if it is in yards
    public static int getConvertedLength (Context context,int currentLengthInMeters){

        double result=currentLengthInMeters;

        if (getCurrentLengthUnit(context).equals(SHARED_UNIT_LENGTH_YARDS)){
            result=currentLengthInMeters*YARDS_PER_METERS;
        }

        return (int) Math.round(result);
    }


    //this method receives a length either in yards or in Meters, check the length aunit nd it returns the same value in if the Setting is in Meter or the value converted to yards if it is in yards
    public static int getLengthInMeters (Context context,int currentLength){

        double result=currentLength;

        if (getCurrentLengthUnit(context).equals(SHARED_UNIT_LENGTH_YARDS)){
            result=currentLength/YARDS_PER_METERS;
        }

        return (int) Math.round(result);
    }




    public static String getFormattedCurrentLengthUnit(Context context){

        String currentUnitLengthValue=SHARED_UNIT_LENGTH_DEFAULT;
        String currentUnitLength=getCurrentLengthUnit(context);

        if (currentUnitLength.equals(SHARED_UNIT_LENGTH_METERS)){

            currentUnitLengthValue=context.getString(R.string.settings_meters_description);

        }else if (currentUnitLength.equals(SHARED_UNIT_LENGTH_YARDS)){
            currentUnitLengthValue=context.getString(R.string.settings_yards_description);
        }

        return currentUnitLengthValue;
    }


    public static String getCurrentLengthUnit (Context context){

        return RetrieveStringFromSharedPreferences(context,SHARED_UNIT_LENGTH_KEY,SHARED_UNIT_LENGTH_DEFAULT);

    }


    public static void setCurrentLengthUnit (Context context, String sharedUnitLength){
        AddStringToSharedPreferences(context,SHARED_UNIT_LENGTH_KEY,sharedUnitLength);
    }



    // this methos gets a length in Meters it checks the selected length unit and it return xxxx meters or xxxx yards making the corresponding convertion if it is needed
    public static String getFormattedLength (Context context,int currentLengthInMeters){

        String formattedLength;
        int convertedLength=getConvertedLength(context,currentLengthInMeters);

        if (getCurrentLengthUnit(context).equals(SHARED_UNIT_LENGTH_METERS)){

            formattedLength=String.format(context.getString(R.string.formatted_meters_length),convertedLength);

        }else {
            formattedLength=String.format(context.getString(R.string.formatted_yards_length),convertedLength);
        }

        return formattedLength;
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


    public static void AddStringToSharedPreferences(Context context,String key, String value){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit= preferences.edit();
        edit.putString(key,value);
        edit.apply();


    }


    public static String RetrieveStringFromSharedPreferences(Context context,String key, String defaultValue){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key,defaultValue);

    }



    public static void RemoveKeyFromSharedPreferences (Context context,String key){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit= preferences.edit();
        edit.remove(key);
        edit.apply();


    }


    public static Hole.Par convertIndexToPar(int index){
        Hole.Par par;

        switch (index){
            case 0:
                par= Hole.Par.PAR_NOT_DEFINED;
                break;
            case 1:
                par= Hole.Par.PAR_3;
                break;
            case 2:
                par= Hole.Par.PAR_4;
                break;
            case 3:
                par= Hole.Par.PAR_5;
                break;
            default:
                par= Hole.Par.PAR_INVALID;
                break;
        }

        return par;
    }


    public static int convertLengthTextViewToInt(EditText lengthTextView){
        int length;

        if (lengthTextView.length()==0){
            length=Hole.NOT_DEFINED_HOLE_LENGTH;
        }else {
            length=Integer.parseInt(lengthTextView.getText().toString().trim());
        }

        return length;
    }



}
