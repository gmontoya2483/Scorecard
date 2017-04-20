package com.montoya.gabi.scorecard.model;

import android.content.ContentValues;
import android.database.Cursor;

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
        this._id=NOT_SAVED_HOLE_ID;

    }

    public GolfFieldHole(Cursor golfFieldHoleCursor) {
        super();

        int index_Id=golfFieldHoleCursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry._ID);
        int indexGF_Id=golfFieldHoleCursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID);
        int indexNumber=golfFieldHoleCursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_NUMBER);
        int indexLength=golfFieldHoleCursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH);
        int indexPar=golfFieldHoleCursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR);

        if (golfFieldHoleCursor.getCount()==1){

            golfFieldHoleCursor.moveToFirst();

            this._id=golfFieldHoleCursor.getLong(index_Id);
            this.golfField_id=golfFieldHoleCursor.getLong(indexGF_Id);
            this.number=golfFieldHoleCursor.getInt(indexNumber);
            this.length=golfFieldHoleCursor.getInt(indexLength);
            this.par=golfFieldHoleCursor.getInt(indexPar);

        }else{
            this._id=INVALID_HOLE_ID;
            this.golfField_id=GolfField.INVALID_GOLF_FIELD_ID;
            this.length=0;
            this.number=HoleNumber.HOLE_INVALID.getValue();
            this.par=Par.PAR_INVALID.getValue();

        }

    }






    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID,this.golfField_id);
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_NUMBER,this.number);
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH,this.length);
        values.put(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR,this.par);


        return values;

    }






}
