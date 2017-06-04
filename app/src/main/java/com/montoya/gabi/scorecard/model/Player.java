package com.montoya.gabi.scorecard.model;

import android.content.Context;

import com.montoya.gabi.scorecard.utils.ScorecardUtils;

/**
 * Created by montoya on 10.04.2017.
 */

public class Player {

    public static int INVALID_HANDICAP=-1;
    public static int MIN_HANDICAP=0;
    public static int MAX_HANDICAP=48;
    public static String SHARED_HANDICAP_KEY="handicap_key";


    public int getHandicap(Context context){
        return ScorecardUtils.RetrieveIntFromSharedPreferences(context,SHARED_HANDICAP_KEY,INVALID_HANDICAP);
    }


    public int SetHandicap(Context context,int value){

        int returnValue=value;

        if (value>MAX_HANDICAP || value<MIN_HANDICAP){
            returnValue=INVALID_HANDICAP;
        }else{
            ScorecardUtils.AddIntToSharedPreferences(context,SHARED_HANDICAP_KEY,value);
        }

        return returnValue;
    }



}
