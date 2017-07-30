package com.montoya.gabi.scorecard.model;

import android.content.ContentValues;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;

/**
 * Created by Gabriel on 15/07/2017.
 */

public class ScorecardHole extends Hole {
    private long _id;
    private long scorecard_Id;
    private int score;
    private int dif;



    public ScorecardHole(long scorecardId, HoleNumber number, int length, Par par, int score, int dif) {
        super(number, length, par);
        this.scorecard_Id = scorecardId;
        this.score = score;
        this.dif = dif;
        this._id=NOT_SAVED_HOLE_ID;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getScorecard_Id() {
        return scorecard_Id;
    }

    public void setScorecard_Id(long scorecard_Id) {
        this.scorecard_Id = scorecard_Id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }



    //Get the content values without the _ID
    public ContentValues getScorecardHoleValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SC_ID,this.getScorecard_Id());
        values.put(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_NUMBER,this.number);
        values.put(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_LENGTH,this.length);
        values.put(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_PAR,this.par);
        values.put(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_SCORE,this.score);
        values.put(ScorecardContract.ScorecardHoleEntry.COLUMN_SCORECARD_HOLE_DIF,this.dif);


        return values;

    }






}
