package com.montoya.gabi.scorecard.model;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

import static com.montoya.gabi.scorecard.model.GolfField.QUANTITY_OF_HOLES;

/**
 * Created by montoya on 10.04.2017.
 */

public class Scorecard {

    public static final long SCORECARD_INVALID_ID=-1L;
    public static final long SCORECARD_NOT_SAVED_ID=0L;
    public static final long SCORECARD_INVALID_DATE=-1L;
    public static final int SCORECARD_INVALID_HANDICAP=Player.INVALID_HANDICAP;
    public static final long SCORECARD_INVALID_GOLF_FIELD_ID=-GolfField.INVALID_GOLF_FIELD_ID;
    public static final String SCORECARD_INVALID_GOLF_FILED_NAME=null;
    public static final int SCORECARD_INVALID_LENGTH=GolfField.INVALID_TOTAL_LENGTH;
    public static final int SCORECARD_INVALID_PAR=GolfField.INVALID_TOTAL_PAR;
    public static final int SCORECARD_INVALID_SCORE=-1;
    public static final int SCORECARD_NOT_DEFINED_SCORE=0;
    public static final int SCORECARD_INVALID_DIF=-99;
    public static final int SCORECARD_QUANTITY_OF_HOLES=GolfField.QUANTITY_OF_HOLES;
    public static final int SCORECARD_INVALID_QUANTITY_OF_HOLES=GolfField.INVALID_QUANTITY_OF_HOLES;



    private long _id;
    private long date;
    private int handicap;

    private long golfField_id;
    private String golfFieldName;
    private int golfFieldTotalLength;
    private int golfFieldTotalPar;
    private int golfFieldOutLength;
    private int golfFieldOutPar;
    private int golfFieldInLength;
    private int golfFieldInPar;

    private int outScore;
    private int outDif;
    private int inScore;
    private int inDif;
    private int grossScore;
    private int grossDif;
    private int netScore;
    private int netDif;


    private ScorecardHole holes [];


    public Scorecard(){
        setDefaultValues();
    }





    public Scorecard(long date, int handicap, long golfField_id, String golfFieldName, int golfFieldTotalLength, int golfFieldTotalPar, int golfFieldOutLength, int golfFieldOutPar, int golfFieldInLength, int golfFieldInPar, int outScore, int outDif, int inScore, int inDif, int grossScore, int grossDif, int netScore, int netDif) {
        this._id=SCORECARD_NOT_SAVED_ID;
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
        this.holes =new ScorecardHole[SCORECARD_QUANTITY_OF_HOLES];

    }


    public Scorecard (Context context, long scorecardId){

        Uri scorecardByIdUri=ScorecardContract.ScorecardEntry.buildScoreCardByIdUri(scorecardId);
        Cursor cursor=context.getContentResolver().query(scorecardByIdUri,null,null,null,null);
        setScorecardValuesFromCursor(cursor);

        if (loadHolesFromDB(context)!=SCORECARD_QUANTITY_OF_HOLES){
            holes=null;
        }

        if (cursor!=null){
            cursor.close();
        }

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

    public ScorecardHole[] getHoles() {
        return holes;
    }

    public ScorecardHole getHole(int index){
        return holes[index];
    }


    public ScorecardHole getHole (Hole.HoleNumber holeNumber){
        ScorecardHole hole;
        switch (holeNumber){
            case HOLE_1:
                hole=this.holes[0];
                break;

            case HOLE_2:
                hole=this.holes[1];
                break;

            case HOLE_3:
                hole=this.holes[2];
                break;

            case HOLE_4:
                hole=this.holes[3];
                break;

            case HOLE_5:
                hole=this.holes[4];
                break;

            case HOLE_6:
                hole=this.holes[5];
                break;

            case HOLE_7:
                hole=this.holes[6];
                break;

            case HOLE_8:
                hole=this.holes[7];
                break;

            case HOLE_9:
                hole=this.holes[8];
                break;

            case HOLE_10:
                hole=this.holes[9];
                break;

            case HOLE_11:
                hole=this.holes[10];
                break;

            case HOLE_12:
                hole=this.holes[11];
                break;

            case HOLE_13:
                hole=this.holes[12];
                break;

            case HOLE_14:
                hole=this.holes[13];
                break;

            case HOLE_15:
                hole=this.holes[14];
                break;

            case HOLE_16:
                hole=this.holes[15];
                break;

            case HOLE_17:
                hole=this.holes[16];
                break;

            case HOLE_18:
                hole=this.holes[17];
                break;
            default:
                hole=null;
                break;
        }

        return hole;
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


    public long insertScorecard(Context context){

        this._id=SCORECARD_INVALID_ID;
        Uri scorecardUri;

        if (validateScorecard() && validateScorecardHolesWithOutScorecardId()){
            scorecardUri=insertScorecardHeader(context);
            if (scorecardUri!=null){
                this._id= ContentUris.parseId(scorecardUri);
                setNewScorecardIdToTheHoles();
                if (insertScorecardHoles(context)!=SCORECARD_QUANTITY_OF_HOLES){

                    deleteScorecard(context);
                    setDefaultValues();
                    this._id=SCORECARD_INVALID_ID;

                }
            }else{
                this._id=SCORECARD_INVALID_ID;

            }

        }else{
            this._id=SCORECARD_INVALID_ID;
        }


        return this._id;
    }


    public boolean validateScorecard(){

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

        if (this.golfFieldName.equals(SCORECARD_INVALID_GOLF_FILED_NAME)){
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


    public boolean validateScorecardHolesWithOutScorecardId(){

        boolean validated=true;

        //Validate the quantity of holes
        if (holes.length!=SCORECARD_QUANTITY_OF_HOLES){
            validated=false;
        }

        //long scorecardId, HoleNumber number, int length, Par par, int score, int dif

        for (ScorecardHole hole:holes){

            //Verify Hole Number
            if ((hole.getNumber()== Hole.HoleNumber.HOLE_INVALID) || (hole.getNumber()== Hole.HoleNumber.HOLE_NOT_DEFINED)){
                validated=false;
            }

            //Verify the length
            if ((hole.getLength()==Hole.INVALID_HOLE_LENGTH) || (hole.getLength()<=Hole.NOT_DEFINED_HOLE_LENGTH)){
                validated=false;

            }

            //Verify the PAR
            if ((hole.getPar()==Hole.Par.PAR_INVALID) || (hole.getPar()== Hole.Par.PAR_NOT_DEFINED)){
                validated=false;
            }

            //Verify the Score
            if ((hole.getScore()==SCORECARD_INVALID_SCORE) || (hole.getScore()<=SCORECARD_NOT_DEFINED_SCORE)){
                validated=false;

            }

            //Verify Dif
            if (hole.getDif()==SCORECARD_INVALID_DIF){
                validated=false;

            }


        }

        return validated;
    }


    private void setNewScorecardIdToTheHoles(){

        for (ScorecardHole hole : holes) {
            hole.setScorecard_Id(this._id);
        }
    }


    private Uri insertScorecardHeader(Context context){
        Uri allScorecardUri=ScorecardContract.ScorecardEntry.buildAllScoreCardUri();
        return context.getContentResolver().insert(allScorecardUri,getScorecardValues());
    }


    private int insertScorecardHoles (Context context){

        return ScorecardHole.bulkInsertScorecardHoles(context,this.holes);

    }


    public static Cursor getAllScorecards(Context context){
        Uri allScorecardsUri=ScorecardContract.ScorecardEntry.buildAllScoreCardUri();
        return context.getContentResolver().query(allScorecardsUri,null,null,null,null);
    }

    public static Cursor getAllScorecardsByGolfField(Context context, long golfField_id){
        Uri scorecardsByGolfFieldUri=ScorecardContract.ScorecardEntry.buildScoreCardByGolfFieldIdUri(golfField_id);
        return context.getContentResolver().query(scorecardsByGolfFieldUri,null,null,null,null);
    }

    public static int getBestGrossScoreDif(Context context){
        int bestGrossDif=SCORECARD_INVALID_DIF;
        Uri ScorecardBestGrossDifUri=ScorecardContract.ScorecardEntry.buildScoreCardBestGrossDifUri();
        Cursor cursor= context.getContentResolver().query(ScorecardBestGrossDifUri,null,null,null,null);
        if (cursor != null) {
            if (cursor.getCount()==1){
                cursor.moveToFirst();
                bestGrossDif=cursor.getInt(cursor.getColumnIndex(ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_GROSS_DIF));

            }
            cursor.close();
        }


        return bestGrossDif;

    }


    public static int getBestGrossScoreDif(Context context, long golfField_id){
        int bestGrossDif=SCORECARD_INVALID_DIF;
        Uri ScorecardBestGrossDifByGolfFieldIdUri=ScorecardContract.ScorecardEntry.buildScoreCardBestGrossDifByGolfFieldIdUri(golfField_id);
        Cursor cursor= context.getContentResolver().query(ScorecardBestGrossDifByGolfFieldIdUri,null,null,null,null);
        if (cursor != null) {
            if (cursor.getCount()==1){
                cursor.moveToFirst();
                bestGrossDif=cursor.getInt(cursor.getColumnIndex(ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_GROSS_DIF));

            }

            cursor.close();
        }
        return bestGrossDif;

    }


    public static int getBestNetScoreDif(Context context){
        int bestNetDif=SCORECARD_INVALID_DIF;
        Uri ScorecardBestNetDifUri=ScorecardContract.ScorecardEntry.buildScoreCardBestNetDifUri();
        Cursor cursor= context.getContentResolver().query(ScorecardBestNetDifUri,null,null,null,null);
        if (cursor != null) {
            if (cursor.getCount()==1){
                cursor.moveToFirst();
                bestNetDif=cursor.getInt(cursor.getColumnIndex(ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_NET_DIF));

            }
            cursor.close();
        }
       return bestNetDif;
    }

    public static int getBestNetScoreDif(Context context, long golfField_id){
        int bestNetDif=SCORECARD_INVALID_DIF;
        Uri ScorecardBestNetDifByGolfFieldIdUri=ScorecardContract.ScorecardEntry.buildScoreCardBestNetDifByGolfFieldIdUri(golfField_id);
        Cursor cursor= context.getContentResolver().query(ScorecardBestNetDifByGolfFieldIdUri,null,null,null,null);
        if (cursor != null) {
            if (cursor.getCount()==1){
                cursor.moveToFirst();
                bestNetDif=cursor.getInt(cursor.getColumnIndex(ScorecardContract.ScorecardEntry.ALIAS_SCORECARD_BEST_NET_DIF));

            }
            cursor.close();
        }
      return bestNetDif;

    }


    public int AddHole (ScorecardHole hole){
        int index=Hole.convertHoleNumberToArrayIndex(hole.getNumber());
        if (index!=Hole.INVALID_HOLE_ARRAY_INDEX){
            this.holes[index]=hole;
        }

        return index;
    }


    private int loadHolesFromDB(Context context){

        int result=SCORECARD_INVALID_QUANTITY_OF_HOLES;

        Uri holesByScorecardIdUri=ScorecardContract.ScorecardHoleEntry.buildAllScorecardHolesByScorecardUri(this._id);
        Cursor cursor=context.getContentResolver().query(holesByScorecardIdUri,null,null,null,null);

        //long scorecardId, HoleNumber number, int length, Par par, int score, int dif

        if (cursor!=null){

            int index_Id=cursor.getColumnIndex(ScorecardContract.ScorecardHoleEntry._ID);
            int index_SC_Id=cursor.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SC_ID);
            int indexNumber=cursor.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_NUMBER);
            int indexLength=cursor.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_LENGTH);
            int indexPar=cursor.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_PAR);
            int indexScore=cursor.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SCORE);
            int indexDif=cursor.getColumnIndex(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_DIF);



            long id;
            long SC_Id;
            Hole.HoleNumber number;
            int length;
            Hole.Par par;
            int score;
            int dif;

            if (cursor.getCount()==SCORECARD_QUANTITY_OF_HOLES){

                this.holes= new ScorecardHole[SCORECARD_QUANTITY_OF_HOLES];//Remove old data from holes to begin from scratch

                while (cursor.moveToNext()){

                    id=cursor.getLong(index_Id);
                    SC_Id=cursor.getLong(index_SC_Id);
                    number=Hole.convertIntToHoleNumber(cursor.getInt(indexNumber));
                    length=cursor.getInt(indexLength);
                    par=Hole.convertIntToPar(cursor.getInt(indexPar));
                    score=cursor.getInt(indexScore);
                    dif=cursor.getInt(indexDif);

                    this.AddHole(new ScorecardHole(id,SC_Id,number,length,par,score,dif));

                }

                result=this.getHoles().length;

            }

        }

        return result;
    }


    private int deleteScorecardHeader(Context context){
        return context.getContentResolver().delete(ScorecardContract.ScorecardEntry.buildScoreCardByIdUri(this._id),null,null);
    }

    private int deleteScorecardHoles (Context context){
        return context.getContentResolver().delete(ScorecardContract.ScorecardHoleEntry.buildAllScorecardHolesByScorecardUri(this._id),null,null);
    }

    public void deleteScorecard (Context context){
        deleteScorecardHoles(context);
        deleteScorecardHeader(context);

    }

    private void setDefaultValues(){
        this._id=SCORECARD_NOT_SAVED_ID;
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

        holes=new ScorecardHole[SCORECARD_QUANTITY_OF_HOLES];

    }


}
