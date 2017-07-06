package com.montoya.gabi.scorecard.model;

import android.content.Context;

import com.montoya.gabi.scorecard.R;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import static com.montoya.gabi.scorecard.utils.ScorecardUtils.RetrieveIntFromSharedPreferences;

/**
 * Created by montoya on 10.04.2017.
 */

public class CurrentScorecard {

    public static final String CURRENT_SCORECARD_EXIST_KEY="current_scorecard_exist";

    private static final String CURRENT_SCORECARD_GOLF_FIELD_ID_KEY="current_scorecard_golf_field_id";
    private static final String CURRENT_SCORECARD_GOLF_FIELD_NAME_KEY="current_scorecard_golf_field_name";
    public static final String CURRENT_SCORECARD_GOLF_FIELD_OUT_LENGTH_KEY="current_scorecard_golf_field_out_length";
    public static final String CURRENT_SCORECARD_GOLF_FIELD_IN_LENGTH_KEY="current_scorecard_golf_field_in_length";
    public static final String CURRENT_SCORECARD_GOLF_FIELD_OUT_PAR_KEY="current_scorecard_golf_field_out_par";
    public static final String CURRENT_SCORECARD_GOLF_FIELD_IN_PAR_KEY="current_scorecard_golf_field_in_par";

    public static final String CURRENT_SCORECARD_DATE_KEY="current_scorecard_date";
    public static final String CURRENT_SCORECARD_HANDICAP_KEY="current_scorecard_handicap";

    private static final String CURRENT_SCORECARD_HOLE_INVALID_KEY="current_scorecard_hole_invalid";
    private static final String LENGTH_SUFFIX="_length";
    private static final String PAR_SUFFIX="_par";
    private static final String SCORE_SUFFIX="_score";


    public static String CURRENT_SCORECARD_HOLE_1_KEY="current_scorecard_hole_1";
    public static String CURRENT_SCORECARD_HOLE_2_KEY="current_scorecard_hole_2";
    public static String CURRENT_SCORECARD_HOLE_3_KEY="current_scorecard_hole_3";
    public static String CURRENT_SCORECARD_HOLE_4_KEY="current_scorecard_hole_4";
    public static String CURRENT_SCORECARD_HOLE_5_KEY="current_scorecard_hole_5";
    public static String CURRENT_SCORECARD_HOLE_6_KEY="current_scorecard_hole_6";
    public static String CURRENT_SCORECARD_HOLE_7_KEY="current_scorecard_hole_7";
    public static String CURRENT_SCORECARD_HOLE_8_KEY="current_scorecard_hole_8";
    public static String CURRENT_SCORECARD_HOLE_9_KEY="current_scorecard_hole_9";
    public static String CURRENT_SCORECARD_HOLE_10_KEY="current_scorecard_hole_10";
    public static String CURRENT_SCORECARD_HOLE_11_KEY="current_scorecard_hole_11";
    public static String CURRENT_SCORECARD_HOLE_12_KEY="current_scorecard_hole_12";
    public static String CURRENT_SCORECARD_HOLE_13_KEY="current_scorecard_hole_13";
    public static String CURRENT_SCORECARD_HOLE_14_KEY="current_scorecard_hole_14";
    public static String CURRENT_SCORECARD_HOLE_15_KEY="current_scorecard_hole_15";
    public static String CURRENT_SCORECARD_HOLE_16_KEY="current_scorecard_hole_16";
    public static String CURRENT_SCORECARD_HOLE_17_KEY="current_scorecard_hole_17";
    public static String CURRENT_SCORECARD_HOLE_18_KEY="current_scorecard_hole_18";




    public static String CURRENT_SCORECARD_GOLF_FIELD_NOT_DEFINED_NAME;
    public static Long CURRENT_SCORECARD_INVALID_GOLF_FIELD_ID;
    public static int CURRENT_SCORECARD_INVALID_LENGTH;
    public static int CURRENT_SCORECARD_INVALID_PAR;
    public static Long CURRENT_SCORECARD_INVALID_DATE;
    public static int CURRENT_SCORECARD_INVALID_HANDICAP;
    public static Hole.HoleNumber CURRENT_SCORECARD_INVALID_HOLE_NUMBER;
    public static int CURRENT_SCORECARD_INVALID_SCORE;
    public static int CURRENT_SCORECARD_NOT_DEFINED_SCORE;
    public static int CURRENT_SCORECARD_NOT_DEFINED_SCORE_DIF;

    private Context mContext;


    public CurrentScorecard(Context context) {
        mContext=context;
        CURRENT_SCORECARD_GOLF_FIELD_NOT_DEFINED_NAME=mContext.getString(R.string.current_scorecard_not_defined_name);
        CURRENT_SCORECARD_INVALID_GOLF_FIELD_ID=GolfField.INVALID_GOLF_FIELD_ID;
        CURRENT_SCORECARD_INVALID_LENGTH=GolfField.INVALID_TOTAL_LENGTH;
        CURRENT_SCORECARD_INVALID_PAR=GolfField.INVALID_TOTAL_PAR;
        CURRENT_SCORECARD_INVALID_DATE=-1L;
        CURRENT_SCORECARD_INVALID_HANDICAP=Player.INVALID_HANDICAP;
        CURRENT_SCORECARD_INVALID_HOLE_NUMBER= Hole.HoleNumber.HOLE_INVALID;
        CURRENT_SCORECARD_INVALID_SCORE=-1;
        CURRENT_SCORECARD_NOT_DEFINED_SCORE=0;
        CURRENT_SCORECARD_NOT_DEFINED_SCORE_DIF=0;
    }


    public void setExistCurrentScorecard(){
        ScorecardUtils.AddBooleanToSharedPreferences(mContext,CURRENT_SCORECARD_EXIST_KEY,true);
    }

    public static boolean getExistCurrentScorecard(Context context){
        return ScorecardUtils.RetrieveBooleanFromSharedPreferences(context,CURRENT_SCORECARD_EXIST_KEY,false);
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


    public void setDate(Long currentDate){
        ScorecardUtils.AddLongToSharedPreferences(mContext,CURRENT_SCORECARD_DATE_KEY,currentDate);
    }


    public Long getDate(){
        return ScorecardUtils.RetrieveLongFromSharedPreferences(mContext,CURRENT_SCORECARD_DATE_KEY,CURRENT_SCORECARD_INVALID_DATE);
    }



    public void setCurrentHandicap(int currentHandicap){
        ScorecardUtils.AddIntToSharedPreferences(mContext,CURRENT_SCORECARD_HANDICAP_KEY,currentHandicap);

    }

    public int getCurrentHandicap (){
        return ScorecardUtils.RetrieveIntFromSharedPreferences(mContext,CURRENT_SCORECARD_HANDICAP_KEY,CURRENT_SCORECARD_INVALID_HANDICAP);
    }



    public void setHoleLength(Hole.HoleNumber holeNumber, int length){
        String holePrefixKey=getCurrentScorecardHolePrefixKey(holeNumber);
        if (!holePrefixKey.equals(CURRENT_SCORECARD_HOLE_INVALID_KEY)){
            String holeKey=holePrefixKey+LENGTH_SUFFIX;
            ScorecardUtils.AddIntToSharedPreferences(mContext,holeKey, length);
        }
    }

    public int getHoleLength(Hole.HoleNumber holeNumber){
        String holePrefixKey=getCurrentScorecardHolePrefixKey(holeNumber);
        int holeLength;

        if (!holePrefixKey.equals(CURRENT_SCORECARD_HOLE_INVALID_KEY)){
            String holeKey=holePrefixKey+LENGTH_SUFFIX;
            holeLength=ScorecardUtils.RetrieveIntFromSharedPreferences(mContext,holeKey, CURRENT_SCORECARD_INVALID_LENGTH);
        }else{
            holeLength=CURRENT_SCORECARD_INVALID_LENGTH;
        }

        return holeLength;
    }


    public void setHolePar(Hole.HoleNumber holeNumber, Hole.Par par){
        String holePrefixKey=getCurrentScorecardHolePrefixKey(holeNumber);
        if (!holePrefixKey.equals(CURRENT_SCORECARD_HOLE_INVALID_KEY)){
            String holeKey=holePrefixKey+PAR_SUFFIX;
            ScorecardUtils.AddIntToSharedPreferences(mContext,holeKey, par.getValue());
        }
    }

    public Hole.Par getHolePar(Hole.HoleNumber holeNumber){
        String holePrefixKey=getCurrentScorecardHolePrefixKey(holeNumber);
        int holePar;

        if (!holePrefixKey.equals(CURRENT_SCORECARD_HOLE_INVALID_KEY)){
            String holeKey=holePrefixKey+PAR_SUFFIX;
            holePar=ScorecardUtils.RetrieveIntFromSharedPreferences(mContext,holeKey, CURRENT_SCORECARD_INVALID_PAR);
        }else{
            holePar=CURRENT_SCORECARD_INVALID_PAR;
        }

        return Hole.convertIntToPar(holePar);
    }


    public void setHoleScore(Hole.HoleNumber holeNumber, int score){
        if (score>=CURRENT_SCORECARD_NOT_DEFINED_SCORE){
            String holePrefixKey=getCurrentScorecardHolePrefixKey(holeNumber);
            if (!holePrefixKey.equals(CURRENT_SCORECARD_HOLE_INVALID_KEY)){
                String holeKey=holePrefixKey+SCORE_SUFFIX;
                ScorecardUtils.AddIntToSharedPreferences(mContext,holeKey, score);
            }

        }
    }


    public int getHoleScore (Hole.HoleNumber holeNumber){
        String holePrefixKey=getCurrentScorecardHolePrefixKey(holeNumber);
        int holeScore;

        if (!holePrefixKey.equals(CURRENT_SCORECARD_HOLE_INVALID_KEY)){
            String holeKey=holePrefixKey+SCORE_SUFFIX;
            holeScore=ScorecardUtils.RetrieveIntFromSharedPreferences(mContext,holeKey, CURRENT_SCORECARD_NOT_DEFINED_SCORE);
        }else{
            holeScore=CURRENT_SCORECARD_INVALID_SCORE;
        }

        return holeScore;

    }


    public int getHoleScoreDif (Hole.HoleNumber holeNumber){

        int dif;
        Hole.Par holePar;
        int score;

        score=getHoleScore(holeNumber);

        if (score==CURRENT_SCORECARD_INVALID_SCORE || score==CURRENT_SCORECARD_NOT_DEFINED_SCORE){
            dif=CURRENT_SCORECARD_NOT_DEFINED_SCORE_DIF;
        }else{
            holePar=getHolePar(holeNumber);
            dif=score-holePar.getValue();
        }

         return dif;
    }




    private String getCurrentScorecardHolePrefixKey(Hole.HoleNumber holeNumber){

        String holePrefixKey;

        switch (holeNumber){
            case HOLE_1:
                holePrefixKey=CURRENT_SCORECARD_HOLE_1_KEY;
                break;
            case HOLE_2:
                holePrefixKey=CURRENT_SCORECARD_HOLE_2_KEY;
                break;
            case HOLE_3:
                holePrefixKey=CURRENT_SCORECARD_HOLE_3_KEY;
                break;
            case HOLE_4:
                holePrefixKey=CURRENT_SCORECARD_HOLE_4_KEY;
                break;
            case HOLE_5:
                holePrefixKey=CURRENT_SCORECARD_HOLE_5_KEY;
                break;
            case HOLE_6:
                holePrefixKey=CURRENT_SCORECARD_HOLE_6_KEY;
                break;
            case HOLE_7:
                holePrefixKey=CURRENT_SCORECARD_HOLE_7_KEY;
                break;
            case HOLE_8:
                holePrefixKey=CURRENT_SCORECARD_HOLE_8_KEY;
                break;
            case HOLE_9:
                holePrefixKey=CURRENT_SCORECARD_HOLE_9_KEY;
                break;
            case HOLE_10:
                holePrefixKey=CURRENT_SCORECARD_HOLE_10_KEY;
                break;
            case HOLE_11:
                holePrefixKey=CURRENT_SCORECARD_HOLE_11_KEY;
                break;
            case HOLE_12:
                holePrefixKey=CURRENT_SCORECARD_HOLE_12_KEY;
                break;
            case HOLE_13:
                holePrefixKey=CURRENT_SCORECARD_HOLE_13_KEY;
                break;
            case HOLE_14:
                holePrefixKey=CURRENT_SCORECARD_HOLE_14_KEY;
                break;
            case HOLE_15:
                holePrefixKey=CURRENT_SCORECARD_HOLE_15_KEY;
                break;
            case HOLE_16:
                holePrefixKey=CURRENT_SCORECARD_HOLE_16_KEY;
                break;
            case HOLE_17:
                holePrefixKey=CURRENT_SCORECARD_HOLE_17_KEY;
                break;
            case HOLE_18:
                holePrefixKey=CURRENT_SCORECARD_HOLE_18_KEY;
                break;

            default:
                holePrefixKey=CURRENT_SCORECARD_HOLE_INVALID_KEY;
                break;
        }




        return holePrefixKey;

    }














}
