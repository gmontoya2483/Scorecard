package com.montoya.gabi.scorecard.model;

import android.content.ContentValues;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;

/**
 * Created by montoya on 13.04.2017.
 */

public class GolfFieldHole extends Hole{






    private long _id;
    private long golfField_id;



    public GolfFieldHole(long golfField_id, HoleNumber holeNumber, int holeLength, Par par) {
        super(holeNumber,holeLength,par);
        this.golfField_id = golfField_id;

    }

    public long get_id() {
        return _id;
    }
    public long getGolfField_id() {
        return golfField_id;
    }

    public void setGolfField_id(long golfField_id) {
        this.golfField_id = golfField_id;
    }





    //Get the content values without the _ID
    public ContentValues getGolfFieldHoleValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID,golfField_id);
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_NUMBER,number.getValue());
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH,length);
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR,par.getValue());


        return values;

    }






}
