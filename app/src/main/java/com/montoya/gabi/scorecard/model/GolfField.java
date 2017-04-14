package com.montoya.gabi.scorecard.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;

import static android.R.attr.id;

/**
 * Created by montoya on 10.04.2017.
 */

public class GolfField {

    private long _id;
    private String name;
    private int favorite;


    public GolfField(String name, int favorite) {

        this.name=name;

        //Check if the favorite flas is ScorecardContract.TRUE_VALUE otherwiese it is forced to ScorecardContract.FALSE_VALUE
        if (favorite== ScorecardContract.TRUE_VALUE){
            this.favorite=ScorecardContract.TRUE_VALUE;

        }else {
            this.favorite=ScorecardContract.FALSE_VALUE;
        }


    }


    public GolfField (Cursor golfFieldCursor){

        int indexGFId=golfFieldCursor.getColumnIndex(ScorecardContract.GolfFieldEntry._ID);
        int indexName=golfFieldCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        int indexFavorite=golfFieldCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);

        if (golfFieldCursor.getCount()==1){

            golfFieldCursor.moveToFirst();

            this._id=golfFieldCursor.getLong(indexGFId);
            this.name=golfFieldCursor.getString(indexName);
            this.favorite=golfFieldCursor.getInt(indexFavorite);

        }else{
            this._id=-1L;
            this.name=null;
            this.favorite=ScorecardContract.FALSE_VALUE;

        }



    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFavorite() {
        return favorite;
    }


    //Get the content values without the _ID
    public ContentValues getGolfFieldValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME,this.getName());
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE,this.getFavorite());

        return values;

    }




}
