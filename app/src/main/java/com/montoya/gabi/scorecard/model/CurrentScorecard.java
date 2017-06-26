package com.montoya.gabi.scorecard.model;

import android.content.Context;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import static com.montoya.gabi.scorecard.utils.ScorecardUtils.RetrieveIntFromSharedPreferences;

/**
 * Created by montoya on 10.04.2017.
 */

public class CurrentScorecard {

    public static String CURRENT_SCORECARD_EXIST_KEY="current_scorecard_exist";

    private static String CURRENT_SCORECARD_GOLF_FIELD_ID_KEY="current_scorecard_golf_field_id";
    private static String CURRENT_SCORECARD_GOLF_FIELD_NAME_KEY="current_scorecard_golf_field_name";
    public static String CURRENT_SCORECARD_GOLF_FIELD_OUT_LENGTH_KEY="current_scorecard_golf_field_out_length";
    public static String CURRENT_SCORECARD_GOLF_FIELD_IN_LENGTH_KEY="current_scorecard_golf_field_in_length";
    public static String CURRENT_SCORECARD_GOLF_FIELD_OUT_PAR_KEY="current_scorecard_golf_field_out_par";
    public static String CURRENT_SCORECARD_GOLF_FIELD_IN_PAR_KEY="current_scorecard_golf_field_in_par";

    public static String CURRENT_SCORECARD_DATE_KEY="current_scorecard_date";
    public static String CURRENT_SCORECARD_HANDICAP_KEY="current_scorecard_date";

    public static String CURRENT_SCORECARD_HOLE_1_LENGTH_KEY="current_scorecard_hole_1_length";
    public static String CURRENT_SCORECARD_HOLE_2_LENGTH_KEY="current_scorecard_hole_2_length";
    public static String CURRENT_SCORECARD_HOLE_3_LENGTH_KEY="current_scorecard_hole_3_length";
    public static String CURRENT_SCORECARD_HOLE_4_LENGTH_KEY="current_scorecard_hole_4_length";
    public static String CURRENT_SCORECARD_HOLE_5_LENGTH_KEY="current_scorecard_hole_5_length";
    public static String CURRENT_SCORECARD_HOLE_6_LENGTH_KEY="current_scorecard_hole_6_length";
    public static String CURRENT_SCORECARD_HOLE_7_LENGTH_KEY="current_scorecard_hole_7_length";
    public static String CURRENT_SCORECARD_HOLE_8_LENGTH_KEY="current_scorecard_hole_8_length";
    public static String CURRENT_SCORECARD_HOLE_9_LENGTH_KEY="current_scorecard_hole_9_length";
    public static String CURRENT_SCORECARD_HOLE_10_LENGTH_KEY="current_scorecard_hole_10_length";
    public static String CURRENT_SCORECARD_HOLE_11_LENGTH_KEY="current_scorecard_hole_11_length";
    public static String CURRENT_SCORECARD_HOLE_12_LENGTH_KEY="current_scorecard_hole_12_length";
    public static String CURRENT_SCORECARD_HOLE_13_LENGTH_KEY="current_scorecard_hole_13_length";
    public static String CURRENT_SCORECARD_HOLE_14_LENGTH_KEY="current_scorecard_hole_14_length";
    public static String CURRENT_SCORECARD_HOLE_15_LENGTH_KEY="current_scorecard_hole_15_length";
    public static String CURRENT_SCORECARD_HOLE_16_LENGTH_KEY="current_scorecard_hole_16_length";
    public static String CURRENT_SCORECARD_HOLE_17_LENGTH_KEY="current_scorecard_hole_17_length";
    public static String CURRENT_SCORECARD_HOLE_18_LENGTH_KEY="current_scorecard_hole_18_length";

    public static String CURRENT_SCORECARD_HOLE_1_PAR_KEY="current_scorecard_hole_1_par";
    public static String CURRENT_SCORECARD_HOLE_2_PAR_KEY="current_scorecard_hole_2_par";
    public static String CURRENT_SCORECARD_HOLE_3_PAR_KEY="current_scorecard_hole_3_par";
    public static String CURRENT_SCORECARD_HOLE_4_PAR_KEY="current_scorecard_hole_4_par";
    public static String CURRENT_SCORECARD_HOLE_5_PAR_KEY="current_scorecard_hole_5_par";
    public static String CURRENT_SCORECARD_HOLE_6_PAR_KEY="current_scorecard_hole_6_par";
    public static String CURRENT_SCORECARD_HOLE_7_PAR_KEY="current_scorecard_hole_7_par";
    public static String CURRENT_SCORECARD_HOLE_8_PAR_KEY="current_scorecard_hole_8_par";
    public static String CURRENT_SCORECARD_HOLE_9_PAR_KEY="current_scorecard_hole_9_par";
    public static String CURRENT_SCORECARD_HOLE_10_PAR_KEY="current_scorecard_hole_10_par";
    public static String CURRENT_SCORECARD_HOLE_11_PAR_KEY="current_scorecard_hole_11_par";
    public static String CURRENT_SCORECARD_HOLE_12_PAR_KEY="current_scorecard_hole_12_par";
    public static String CURRENT_SCORECARD_HOLE_13_PAR_KEY="current_scorecard_hole_13_par";
    public static String CURRENT_SCORECARD_HOLE_14_PAR_KEY="current_scorecard_hole_14_par";
    public static String CURRENT_SCORECARD_HOLE_15_PAR_KEY="current_scorecard_hole_15_par";
    public static String CURRENT_SCORECARD_HOLE_16_PAR_KEY="current_scorecard_hole_16_par";
    public static String CURRENT_SCORECARD_HOLE_17_PAR_KEY="current_scorecard_hole_17_par";
    public static String CURRENT_SCORECARD_HOLE_18_PAR_KEY="current_scorecard_hole_18_par";

    public static String CURRENT_SCORECARD_HOLE_1_SCORE_KEY="current_scorecard_hole_1_score";
    public static String CURRENT_SCORECARD_HOLE_2_SCORE_KEY="current_scorecard_hole_2_score";
    public static String CURRENT_SCORECARD_HOLE_3_SCORE_KEY="current_scorecard_hole_3_score";
    public static String CURRENT_SCORECARD_HOLE_4_SCORE_KEY="current_scorecard_hole_4_score";
    public static String CURRENT_SCORECARD_HOLE_5_SCORE_KEY="current_scorecard_hole_5_score";
    public static String CURRENT_SCORECARD_HOLE_6_SCORE_KEY="current_scorecard_hole_6_score";
    public static String CURRENT_SCORECARD_HOLE_7_SCORE_KEY="current_scorecard_hole_7_score";
    public static String CURRENT_SCORECARD_HOLE_8_SCORE_KEY="current_scorecard_hole_8_score";
    public static String CURRENT_SCORECARD_HOLE_9_SCORE_KEY="current_scorecard_hole_9_score";
    public static String CURRENT_SCORECARD_HOLE_10_SCORE_KEY="current_scorecard_hole_10_score";
    public static String CURRENT_SCORECARD_HOLE_11_SCORE_KEY="current_scorecard_hole_11_score";
    public static String CURRENT_SCORECARD_HOLE_12_SCORE_KEY="current_scorecard_hole_12_score";
    public static String CURRENT_SCORECARD_HOLE_13_SCORE_KEY="current_scorecard_hole_13_score";
    public static String CURRENT_SCORECARD_HOLE_14_SCORE_KEY="current_scorecard_hole_14_score";
    public static String CURRENT_SCORECARD_HOLE_15_SCORE_KEY="current_scorecard_hole_15_score";
    public static String CURRENT_SCORECARD_HOLE_16_SCORE_KEY="current_scorecard_hole_16_score";
    public static String CURRENT_SCORECARD_HOLE_17_SCORE_KEY="current_scorecard_hole_17_score";
    public static String CURRENT_SCORECARD_HOLE_18_SCORE_KEY="current_scorecard_hole_18_score";


    public static String CURRENT_SCORECARD_GOLF_FIELD_NOT_DEFINED_NAME;
    public static Long CURRENT_SCORECARD_INVALID_GOLF_FIELD_ID;
    public static int CURRENT_SCORECARD_INVALID_LENGTH;
    public static int CURRENT_SCORECARD_INVALID_PAR;

    private Context mContext;


    public CurrentScorecard(Context context) {
        mContext=context;
        CURRENT_SCORECARD_GOLF_FIELD_NOT_DEFINED_NAME=mContext.getString(R.string.current_scorecard_not_defined_name);
        CURRENT_SCORECARD_INVALID_GOLF_FIELD_ID=GolfField.INVALID_GOLF_FIELD_ID;
        CURRENT_SCORECARD_INVALID_LENGTH=GolfField.INVALID_TOTAL_LENGTH;
        CURRENT_SCORECARD_INVALID_PAR=GolfField.INVALID_TOTAL_PAR;
    }


    public void setGolfFieldId(Long golfFieldID){
        ScorecardUtils.AddLongToSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_ID_KEY,golfFieldID);
    }

    public Long getGolfFieldId(){
        return ScorecardUtils.RetrieveLongFromSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_ID_KEY,CURRENT_SCORECARD_INVALID_GOLF_FIELD_ID);
    }

    public void setGolfFieldName(String golfFieldName){
        ScorecardUtils.AddStringToSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_NAME_KEY,golfFieldName);
    }

    public String getGolfFieldName(){
        return ScorecardUtils.RetrieveStringFromSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_NAME_KEY,CURRENT_SCORECARD_GOLF_FIELD_NOT_DEFINED_NAME);
    }

    public void setGolfFieldOutLength(int golfFieldOutLength){
        ScorecardUtils.AddIntToSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_OUT_LENGTH_KEY,golfFieldOutLength);
    }

    public int getGolfFieldOutLength(){
        return RetrieveIntFromSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_OUT_LENGTH_KEY, CURRENT_SCORECARD_INVALID_LENGTH);
    }

    public void setGolfFieldInLength(int golfFieldInLength){
        ScorecardUtils.AddIntToSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_IN_LENGTH_KEY,golfFieldInLength);
    }

    public int getGolfFieldInLength(){
        return RetrieveIntFromSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_IN_LENGTH_KEY, CURRENT_SCORECARD_INVALID_LENGTH);
    }


    public int getGolfFieldTotalLength(){
        int total;
        int inLength= getGolfFieldInLength();
        int outLength= getGolfFieldOutLength();

        if (inLength==CURRENT_SCORECARD_INVALID_LENGTH || outLength==CURRENT_SCORECARD_INVALID_LENGTH){
            total=CURRENT_SCORECARD_INVALID_LENGTH;
        }else{
            total=inLength+outLength;
        }

        return total;
    }


    public void setGolfFieldOutPar(int golfFieldOutPar){

        ScorecardUtils.AddIntToSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_OUT_PAR_KEY,golfFieldOutPar);
    }

    public int getGolfFieldOutPar(){
        return RetrieveIntFromSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_OUT_PAR_KEY, CURRENT_SCORECARD_INVALID_PAR);
    }

    public void setGolfFieldInPar(int golfFieldInPar){

        ScorecardUtils.AddIntToSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_IN_PAR_KEY,golfFieldInPar);
    }

    public int getGolfFieldInPar(){
        return RetrieveIntFromSharedPreferences(mContext,CURRENT_SCORECARD_GOLF_FIELD_IN_PAR_KEY, CURRENT_SCORECARD_INVALID_PAR);
    }

    public int getGolfFieldTotalPar(){
        int total;
        int inPar= getGolfFieldInPar();
        int outPar= getGolfFieldOutPar();

        if (inPar==CURRENT_SCORECARD_INVALID_PAR || outPar==CURRENT_SCORECARD_INVALID_PAR){
            total=CURRENT_SCORECARD_INVALID_PAR;
        }else{
            total=inPar+outPar;
        }

        return total;
    }









}
