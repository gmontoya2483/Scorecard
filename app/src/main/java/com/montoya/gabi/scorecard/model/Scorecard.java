package com.montoya.gabi.scorecard.model;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;

import java.util.Date;

/**
 * Created by montoya on 10.04.2017.
 */

public class Scorecard {

    public static final long SCORECARD_INVALID_ID=-1L;
    public static final long SCORECARD_INVALID_DATE=-1L;
    public static final int SCORECARD_INVALID_HANDICAP=Player.INVALID_HANDICAP;
    public static final long SCORECARD_INVALID_GOLF_FIELD_ID=-GolfField.INVALID_GOLF_FIELD_ID;
    public static final String SCORECARD_INVALID_GOLF_FILED_NAME=null;
    public static final int SCORECARD_INVALID_LENGTH=GolfField.INVALID_TOTAL_LENGTH;
    public static final int SCORECARD_INVALID_PAR=GolfField.INVALID_TOTAL_PAR;
    public static final int SCORECARD_INVALID_SCORE=-1;
    public static final int SCORECARD_INVALID_DIF=-99;


    private long _id;
    private long date=SCORECARD_INVALID_DATE;
    private int handicap=SCORECARD_INVALID_HANDICAP;

    private long golfField_id=SCORECARD_INVALID_GOLF_FIELD_ID;
    private String golfFieldName=SCORECARD_INVALID_GOLF_FILED_NAME;
    private int golfFieldTotalLength=SCORECARD_INVALID_LENGTH;
    private int golfFieldTotalPar=SCORECARD_INVALID_PAR;
    private int golfFieldOutLength=SCORECARD_INVALID_LENGTH;
    private int golfFieldOutPar=SCORECARD_INVALID_PAR;
    private int golfFieldInLength=SCORECARD_INVALID_LENGTH;
    private int golfFieldInPar=SCORECARD_INVALID_PAR;

    private int outScore=SCORECARD_INVALID_SCORE;
    private int outDif=SCORECARD_INVALID_DIF;
    private int inScore=SCORECARD_INVALID_SCORE;
    private int inDif=SCORECARD_INVALID_DIF;
    private int grossScore=SCORECARD_INVALID_SCORE;
    private int grossDif=SCORECARD_INVALID_DIF;
    private int netScore=SCORECARD_INVALID_SCORE;
    private int netDif=SCORECARD_INVALID_DIF;


    public Scorecard(long date, int handicap, long golfField_id, String golfFieldName, int golfFieldTotalLength, int golfFieldTotalPar, int golfFieldOutLength, int golfFieldOutPar, int golfFieldInLength, int golfFieldInPar, int outScore, int outDif, int inScore, int inDif, int grossScore, int grossDif, int netScore, int netDif) {
        this.date = date;
        this.handicap = handicap;
        this.golfField_id = golfField_id;
        this.golfFieldName = golfFieldName;
        this.golfFieldTotalLength = golfFieldTotalLength;
        this.golfFieldTotalPar = golfFieldTotalPar;
        this.golfFieldOutLength = golfFieldOutLength;
        this.golfFieldOutPar = golfFieldOutPar;
        this.golfFieldInLength = golfFieldInLength;
        this.golfFieldInPar = golfFieldInPar;
        this.outScore = outScore;
        this.outDif = outDif;
        this.inScore = inScore;
        this.inDif = inDif;
        this.grossScore = grossScore;
        this.grossDif = grossDif;
        this.netScore = netScore;
        this.netDif = netDif;
    }


    public Scorecard (Context context, long scorecardId){

        Uri scorecardByIdUri=ScorecardContract.ScorecardEntry.buildScoreCardByIdUri(scorecardId);
        Cursor cursor=context.getContentResolver().query(scorecardByIdUri,null,null,null,null);
        setScorecardValuesFromCursor(cursor);
        cursor.close();;

    }



    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public long getGolfField_id() {
        return golfField_id;
    }

    public void setGolfField_id(long golfField_id) {
        this.golfField_id = golfField_id;
    }

    public String getGolfFieldName() {
        return golfFieldName;
    }

    public void setGolfFieldName(String golfFieldName) {
        this.golfFieldName = golfFieldName;
    }

    public int getGolfFieldTotalLength() {
        return golfFieldTotalLength;
    }

    public void setGolfFieldTotalLength(int golfFieldTotalLength) {
        this.golfFieldTotalLength = golfFieldTotalLength;
    }

    public int getGolfFieldTotalPar() {
        return golfFieldTotalPar;
    }

    public void setGolfFieldTotalPar(int golfFieldTotalPar) {
        this.golfFieldTotalPar = golfFieldTotalPar;
    }

    public int getGolfFieldOutLength() {
        return golfFieldOutLength;
    }

    public void setGolfFieldOutLength(int golfFieldOutLength) {
        this.golfFieldOutLength = golfFieldOutLength;
    }

    public int getGolfFieldOutPar() {
        return golfFieldOutPar;
    }

    public void setGolfFieldOutPar(int golfFieldOutPar) {
        this.golfFieldOutPar = golfFieldOutPar;
    }

    public int getGolfFieldInLength() {
        return golfFieldInLength;
    }

    public void setGolfFieldInLength(int golfFieldInLength) {
        this.golfFieldInLength = golfFieldInLength;
    }

    public int getGolfFieldInPar() {
        return golfFieldInPar;
    }

    public void setGolfFieldInPar(int golfFieldInPar) {
        this.golfFieldInPar = golfFieldInPar;
    }

    public int getOutScore() {
        return outScore;
    }

    public void setOutScore(int outScore) {
        this.outScore = outScore;
    }

    public int getOutDif() {
        return outDif;
    }

    public void setOutDif(int outDif) {
        this.outDif = outDif;
    }

    public int getInScore() {
        return inScore;
    }

    public void setInScore(int inScore) {
        this.inScore = inScore;
    }

    public int getInDif() {
        return inDif;
    }

    public void setInDif(int inDif) {
        this.inDif = inDif;
    }

    public int getGrossScore() {
        return grossScore;
    }

    public void setGrossScore(int grossScore) {
        this.grossScore = grossScore;
    }

    public int getGrossDif() {
        return grossDif;
    }

    public void setGrossDif(int grossDif) {
        this.grossDif = grossDif;
    }

    public int getNetScore() {
        return netScore;
    }

    public void setNetScore(int netScore) {
        this.netScore = netScore;
    }

    public int getNetDif() {
        return netDif;
    }

    public void setNetDif(int netDif) {
        this.netDif = netDif;
    }



    private void setScorecardValuesFromCursor(Cursor scorecardCursor){

        int index_id=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry._ID);
        int indexDate=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_DATE);
        int indexHandicap= scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_HANDICAP);
        int indexGolfField_id=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID);
        int indexGolfFieldName=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME);
        int indexGolfFieldTotalLength=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_LENGTH);
        int indexGolfFieldTotalPar=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_PAR);
        int indexGolfFieldOutLength=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_LENGTH);
        int indexGolfFieldOutPar=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_PAR);
        int indexGolfFieldInLength=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_LENGTH);
        int indexGolfFieldInPar=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_PAR);
        int indexOutScore=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_SCORE);
        int indexOutDif=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_DIF);
        int indexInScore=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_SCORE);
        int indexInDif=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_DIF);
        int indexGrossScore=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_SCORE);
        int indexGrossDif=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF);
        int indexNetScore=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_SCORE);
        int indexNetDif=scorecardCursor.getColumnIndex(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF);


        if (scorecardCursor.getCount()==1){

            scorecardCursor.moveToFirst();

            this._id=scorecardCursor.getLong(index_id);
            this.date=scorecardCursor.getLong(indexDate);
            this.handicap = scorecardCursor.getInt(indexHandicap);
            this.golfField_id=scorecardCursor.getLong(indexGolfField_id);
            this.golfFieldName = scorecardCursor.getString(indexGolfFieldName);
            this.golfFieldTotalLength = scorecardCursor.getInt(indexGolfFieldTotalLength);
            this.golfFieldTotalPar = scorecardCursor.getInt(indexGolfFieldTotalPar);
            this.golfFieldOutLength = scorecardCursor.getInt(indexGolfFieldOutLength);
            this.golfFieldOutPar = scorecardCursor.getInt(indexGolfFieldOutPar);
            this.golfFieldInLength = scorecardCursor.getInt(indexGolfFieldInLength);
            this.golfFieldInPar = scorecardCursor.getInt(indexGolfFieldInPar);
            this.outScore = scorecardCursor.getInt(indexOutScore);
            this.outDif = scorecardCursor.getInt(indexOutDif);
            this.inScore = scorecardCursor.getInt(indexInScore);
            this.inDif = scorecardCursor.getInt(indexInDif);
            this.grossScore = scorecardCursor.getInt(indexGrossScore);
            this.grossDif = scorecardCursor.getInt(indexGrossDif);
            this.netScore = scorecardCursor.getInt(indexNetScore);
            this.netDif = scorecardCursor.getInt(indexNetDif);


        }else{

            this._id=SCORECARD_INVALID_ID;
            this.date = SCORECARD_INVALID_DATE;
            this.handicap = SCORECARD_INVALID_HANDICAP;
            this.golfField_id = SCORECARD_INVALID_GOLF_FIELD_ID;
            this.golfFieldName = SCORECARD_INVALID_GOLF_FILED_NAME;
            this.golfFieldTotalLength = SCORECARD_INVALID_LENGTH;
            this.golfFieldTotalPar = SCORECARD_INVALID_PAR;
            this.golfFieldOutLength = SCORECARD_INVALID_LENGTH;
            this.golfFieldOutPar = SCORECARD_INVALID_PAR;
            this.golfFieldInLength = SCORECARD_INVALID_LENGTH;
            this.golfFieldInPar = SCORECARD_INVALID_PAR;
            this.outScore = SCORECARD_INVALID_SCORE;
            this.outDif = SCORECARD_INVALID_DIF;
            this.inScore = SCORECARD_INVALID_SCORE;
            this.inDif = SCORECARD_INVALID_DIF;
            this.grossScore = SCORECARD_INVALID_SCORE;
            this.grossDif = SCORECARD_INVALID_DIF;
            this.netScore = SCORECARD_INVALID_SCORE;
            this.netDif = SCORECARD_INVALID_DIF;


        }

    }



    //Get the content values without the _ID
    public ContentValues getScorecardValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_ID,this.golfField_id);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_NAME,this.golfFieldName);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_LENGTH,this.golfFieldTotalLength);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_TOTAL_PAR,this.golfFieldTotalPar);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_LENGTH,this.golfFieldOutLength);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_OUT_PAR,this.golfFieldOutPar);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_LENGTH,this.golfFieldInLength);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GF_IN_PAR,this.golfFieldInPar);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_DATE,this.date);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_HANDICAP,this.handicap);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_SCORE,this.outScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_OUT_DIF,this.outDif);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_SCORE,this.inScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_IN_DIF,this.inDif);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_SCORE,this.grossScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_GROSS_DIF,this.grossDif);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_SCORE,this.netScore);
        values.put(ScorecardContract.ScorecardEntry.COLUMN_SCORECARD_NET_DIF,this.netDif);

        return values;

    }


    public boolean insertScorecard(Context context){

        boolean insertedScorecardOK=true;
        Uri scorecardUri;

        if (validateScorecard() && validateScorecardHoles()){
            scorecardUri=insertScorecardHeader(context);
            if (scorecardUri!=null){
                this._id= ContentUris.parseId(scorecardUri);

            }else{

                this._id=SCORECARD_INVALID_ID;

            }

        }else{
            insertedScorecardOK=false;
        }


        return insertedScorecardOK;
    }


    private boolean validateScorecard(){

        boolean validationOK=true;


        if (this.date == SCORECARD_INVALID_DATE){
            validationOK=false;
        }

        if (this.handicap == SCORECARD_INVALID_HANDICAP){
            validationOK=false;
        }

        if(this.golfField_id == SCORECARD_INVALID_GOLF_FIELD_ID){
            validationOK=false;
        }

        if (this.golfFieldName == SCORECARD_INVALID_GOLF_FILED_NAME){
            validationOK=false;
        }

        if (this.golfFieldTotalLength == SCORECARD_INVALID_LENGTH){
            validationOK=false;
        }

        if (this.golfFieldTotalPar == SCORECARD_INVALID_PAR){
            validationOK=false;
        }
        if (this.golfFieldOutLength == SCORECARD_INVALID_LENGTH){
            validationOK=false;
        }
        if (this.golfFieldOutPar == SCORECARD_INVALID_PAR){
            validationOK=false;
        }
        if (this.golfFieldInLength == SCORECARD_INVALID_LENGTH){
            validationOK=false;
        }
        if (this.golfFieldInPar == SCORECARD_INVALID_PAR){
            validationOK=false;
        }
        if (this.outScore == SCORECARD_INVALID_SCORE){
            validationOK=false;
        }
        if (this.outDif == SCORECARD_INVALID_DIF){
            validationOK=false;
        }
        if (this.inScore == SCORECARD_INVALID_SCORE){
            validationOK=false;
        }
        if (this.inDif == SCORECARD_INVALID_DIF){
            validationOK=false;
        }
        if (this.grossScore == SCORECARD_INVALID_SCORE){
            validationOK=false;
        }
        if (this.grossDif == SCORECARD_INVALID_DIF){
            validationOK=false;
        }
        if (this.netScore == SCORECARD_INVALID_SCORE){
            validationOK=false;
        }
        if (this.netDif == SCORECARD_INVALID_DIF){
            validationOK=false;
        }

        return validationOK;
    }


    private boolean validateScorecardHoles(){
        return true; //TODO hacer la validacion
    }


    private Uri insertScorecardHeader(Context context){

        Uri allScorecardUri=ScorecardContract.ScorecardEntry.buildAllScoreCardUri();
        return context.getContentResolver().insert(allScorecardUri,getScorecardValues());

    }

    public static Cursor getAllScorecards(Context context){
        Uri allScorecardsUri=ScorecardContract.ScorecardEntry.buildAllScoreCardUri();
        return context.getContentResolver().query(allScorecardsUri,null,null,null,null);
    }

    public static Cursor getAllScorecardsByGolfField(Context context, long golfField_id){
        Uri scorecardsByGolfFieldUri=ScorecardContract.ScorecardEntry.buildScoreCardByGolfFieldIdUri(golfField_id);
        return context.getContentResolver().query(scorecardsByGolfFieldUri,null,null,null,null);
    }




}
