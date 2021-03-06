package com.montoya.gabi.scorecard.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.EditText;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.model.CurrentScorecard;
import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;

import static com.montoya.gabi.scorecard.model.GolfField.NOT_SAVED_GOLF_FIELD_ID;

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

    public static String getFormattedHoleNumber (Context context, Hole.HoleNumber holeNumber){
        return String.format(context.getString(R.string.formatted_hole),holeNumber.getValue());
    }



    public static String getFormattedScore(int score){
        String formattedScore;
        if (score== CurrentScorecard.CURRENT_SCORECARD_INVALID_SCORE || score==CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE){
            formattedScore="";
        }else{
            formattedScore=Integer.toString(score);
        }

        return formattedScore;
    }


    public static String getFormattedScoreDif (int scoreDif){
        String formattedScoreDif;
        if (scoreDif == CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE_DIF){
            formattedScoreDif="";
        }else if (scoreDif>CurrentScorecard.CURRENT_SCORECARD_NOT_DEFINED_SCORE_DIF){


            formattedScoreDif="+ "+Integer.toString(scoreDif);
        }else{
            formattedScoreDif=Integer.toString(scoreDif);
        }

        return formattedScoreDif;
    }


    public static String getFormattedHandicap(int handicap){
            return Integer.toString(handicap);
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


    public static int RetrieveIntFromSharedPreferences(Context context,String key, int defaultValue){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key,defaultValue);

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


    public static void AddLongToSharedPreferences(Context context,String key, Long value){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit= preferences.edit();
        edit.putLong(key,value);
        edit.apply();

    }


    public static Long RetrieveLongFromSharedPreferences(Context context,String key, Long defaultValue){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getLong(key,defaultValue);

    }

    public static void AddBooleanToSharedPreferences(Context context,String key, boolean value){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit= preferences.edit();
        edit.putBoolean(key,value);
        edit.apply();

    }

    public static boolean RetrieveBooleanFromSharedPreferences(Context context,String key, boolean defaultValue){

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key,defaultValue);

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


    public static String convertIndexToUnitLength(int index){
        String UnitLength;
        switch(index){
            case 0:
                UnitLength= SHARED_UNIT_LENGTH_METERS;
                break;
            case 1:
                UnitLength= SHARED_UNIT_LENGTH_YARDS;
                break;
            default:
                UnitLength= SHARED_UNIT_LENGTH_DEFAULT;
                break;
        }


        return UnitLength;
    }



    public static int convertParToIndex(GolfFieldHole hole){
        int index=0;

        switch (hole.getPar()){
            case PAR_3:
                index=1;
                break;
            case PAR_4:
                index=2;
                break;
            case PAR_5:
                index=3;
                break;
            default:
                index=0;
                break;
        }

        return index;

    }


    public static int convertUnitLengthToIndex (String unitLength){
        int index;

        switch (unitLength){
            case ScorecardUtils.SHARED_UNIT_LENGTH_METERS:
                index=0;
                break;

            case ScorecardUtils.SHARED_UNIT_LENGTH_YARDS:
                index=1;
                break;

            default:
                if (ScorecardUtils.SHARED_UNIT_LENGTH_DEFAULT==ScorecardUtils.SHARED_UNIT_LENGTH_METERS){
                    index=0;
                }else{
                    index=1;
                }

                break;
        }

        return index;
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



    @NonNull
    public static String getConvertedHoleLengthString (Context context, GolfFieldHole hole){
        return String.valueOf(getConvertedLength(context,hole.getLength()));
    }


    public static void generatePreLoadedGolfFields(Context mContext){

        GolfField golfField;

        //Insert Golf field 1
        golfField=new GolfField("Aranzazu Country Club", ScorecardContract.ScorecardBoolean.FALSE, ScorecardContract.ScorecardBoolean.TRUE);
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,320, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,120, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,220, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,120, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,223, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,148, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,110, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,120, Hole.Par.PAR_3) );

        if (!golfField.InsertGolfField(mContext)){
            Log.e(APP_LOG_TAG,"The golf field was not inserted");
        }


        //Insert Golf Field 2
        golfField=new GolfField("Circulo Policial Argentino", ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,320, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,120, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,220, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,120, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,223, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,148, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,110, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,120, Hole.Par.PAR_3) );

        if (!golfField.InsertGolfField(mContext)){
            Log.e(APP_LOG_TAG,"The golf field was not inserted");
        }


        //Insert Golf Field 2
        golfField=new GolfField("Olivos golf", ScorecardContract.ScorecardBoolean.TRUE, ScorecardContract.ScorecardBoolean.TRUE);
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,320, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,120, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,220, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,120, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,223, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,148, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,110, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,120, Hole.Par.PAR_3) );

        if (!golfField.InsertGolfField(mContext)){
            Log.e(APP_LOG_TAG,"The golf field was not inserted");
        }


        //Insert Golf Field 2
        golfField=new GolfField("Golfers", ScorecardContract.ScorecardBoolean.FALSE, ScorecardContract.ScorecardBoolean.TRUE);
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,220, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,320, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,320, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,120, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,220, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,120, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,223, Hole.Par.PAR_5) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,148, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,120, Hole.Par.PAR_3) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,110, Hole.Par.PAR_4) );
        golfField.AddHole(new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,120, Hole.Par.PAR_3) );

        if (!golfField.InsertGolfField(mContext)){
            Log.e(APP_LOG_TAG,"The golf field was not inserted");
        }




    }








}
