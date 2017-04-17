package com.montoya.gabi.scorecard.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardContract.ScorecardBoolean;

import static android.R.attr.id;

/**
 * Created by montoya on 10.04.2017.
 */

public class GolfField {


    public static Long INVALID_GOLF_FIELD_ID=-1L;

    private long _id;
    private String name;
    private int favorite;
    private int active;

    private GolfFieldHole holes []=new GolfFieldHole[18];


    public GolfField(String name, ScorecardBoolean favorite, ScorecardBoolean active) {

        this.name=name;
        this.favorite=favorite.getValue();
        this.active= active.getValue();

    }


    public GolfField(String name, ScorecardBoolean favorite, ScorecardBoolean active, GolfFieldHole[] holes) {

        this.name=name;
        this.favorite=favorite.getValue();
        this.active= active.getValue();

        setHolesFromArray(holes);

    }


    public GolfField (Cursor golfFieldCursor){

        int indexGFId=golfFieldCursor.getColumnIndex(ScorecardContract.GolfFieldEntry._ID);
        int indexName=golfFieldCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        int indexFavorite=golfFieldCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);
        int indexActive=golfFieldCursor.getColumnIndex(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE);

        if (golfFieldCursor.getCount()==1){

            golfFieldCursor.moveToFirst();

            this._id=golfFieldCursor.getLong(indexGFId);
            this.name=golfFieldCursor.getString(indexName);
            this.favorite=golfFieldCursor.getInt(indexFavorite);
            this.active=golfFieldCursor.getInt(indexActive);

        }else{
            this._id=INVALID_GOLF_FIELD_ID;
            this.name=null;
            this.favorite=ScorecardBoolean.FALSE.getValue();
            this.active=ScorecardBoolean.FALSE.getValue();

        }



    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public ScorecardBoolean getFavorite() {
        ScorecardBoolean favorite;
        switch (this.favorite){
            case 1:
                favorite=ScorecardBoolean.TRUE;
                break;
            case 0:
                favorite=ScorecardBoolean.FALSE;
                break;
            default:
                favorite=ScorecardBoolean.FALSE;
                break;

        }
        return favorite;
    }

    public ScorecardBoolean getActive() {
        ScorecardBoolean active;
        switch (this.active){
            case 1:
                active=ScorecardBoolean.TRUE;
                break;
            case 0:
                active=ScorecardBoolean.FALSE;
                break;
            default:
                active=ScorecardBoolean.FALSE;
                break;

        }
        return active;
    }


    //Get the content values without the _ID
    public ContentValues getGolfFieldValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME,this.name);
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE,this.favorite);
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE,this.active);

        return values;

    }


    public void setHolesFromArray (GolfFieldHole[] holes){


        if (holes.length<=18){

            for (int i=0;i<holes.length;i++){
                int index = addHole(holes[i]);
            }

        }

    }


    public int addHole (GolfFieldHole hole){
        int index;
        switch (hole.getNumber()){
            case HOLE_1:
                index=0;
                this.holes[index]=hole;
                break;

            case HOLE_2:
                index=1;
                this.holes[index]=hole;
                break;

            case HOLE_3:
                index=2;
                this.holes[index]=hole;
                break;

            case HOLE_4:
                index=3;
                this.holes[index]=hole;
                break;

            case HOLE_5:
                index=4;
                this.holes[index]=hole;
                break;

            case HOLE_6:
                index=5;
                this.holes[index]=hole;
                break;

            case HOLE_7:
                index=6;
                this.holes[index]=hole;
                break;

            case HOLE_8:
                index=7;
                this.holes[index]=hole;
                break;

            case HOLE_9:
                index=8;
                this.holes[index]=hole;
                break;

            case HOLE_10:
                index=9;
                this.holes[index]=hole;
                break;

            case HOLE_11:
                index=10;
                this.holes[index]=hole;
                break;

            case HOLE_12:
                index=11;
                this.holes[index]=hole;
                break;

            case HOLE_13:
                index=12;
                this.holes[index]=hole;
                break;

            case HOLE_14:
                index=13;
                this.holes[index]=hole;
                break;

            case HOLE_15:
                index=14;
                this.holes[index]=hole;
                break;

            case HOLE_16:
                index=15;
                this.holes[index]=hole;
                break;

            case HOLE_17:
                index=16;
                this.holes[index]=hole;
                break;

            case HOLE_18:
                index=17;
                this.holes[index]=hole;
                break;
            default:
                index=-1;
                break;
        }


        return index;
    }


}
