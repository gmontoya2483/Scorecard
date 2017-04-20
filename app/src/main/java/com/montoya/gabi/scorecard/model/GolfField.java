package com.montoya.gabi.scorecard.model;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardContract.ScorecardBoolean;

/**
 * Created by montoya on 10.04.2017.
 */

public class GolfField {


    public static Long INVALID_GOLF_FIELD_ID=-1L;
    public static Long NOT_SAVED_GOLF_FIELD_ID=0L; //Default id when the golffield whasent been saved into the Database

    private long _id;
    private String name;
    private int favorite;
    private int active;


    private GolfFieldHole holes []=new GolfFieldHole[18];


    public GolfField(String name, ScorecardBoolean favorite, ScorecardBoolean active) {

        setGolfFieldAttributes(name, favorite, active);

    }


    public GolfField(String name, ScorecardBoolean favorite, ScorecardBoolean active, GolfFieldHole[] holes) {

        this.name=name;
        this.favorite=favorite.getValue();
        this.active= active.getValue();



        setHolesFromArray(holes);

    }


    //Constructor helper methed to setup the att
    private void setGolfFieldAttributes(String name, ScorecardBoolean favorite, ScorecardBoolean active){

        this._id=this.NOT_SAVED_GOLF_FIELD_ID;
        this.name=name;
        this.favorite=favorite.getValue();
        this.active= active.getValue();

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

    public long get_id() {
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



    public GolfFieldHole getHole (Hole.HoleNumber holeNumber){
        GolfFieldHole hole;
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



    public void setHolesFromArray (GolfFieldHole[] holes){


        if (holes.length<=18){

            for (int i=0;i<holes.length;i++){
                int index = AddHole(holes[i]);
            }

        }

    }


    public int AddHole (GolfFieldHole hole){
        int index;

        //Ensure the golffield ID will be the one for this field
        hole.setGolfField_id(this._id);

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


    public long saveGolfField(Context context){

        long saved_gf_id;


        if (this._id==GolfField.NOT_SAVED_GOLF_FIELD_ID || this._id==GolfField.INVALID_GOLF_FIELD_ID){
           saved_gf_id=insertGolfFieldWithHoles(context);

        }else {
            //TODO UPDATE
            saved_gf_id=this._id;
        }

        return saved_gf_id;

    }



    //Helper Method to insert a new GolfField
    private Long insertGolfFieldWithHoles(Context context){

        Long golfField_id;
        Uri golfFieldUri;
        int qtyInsertedHoles;

        boolean gf_OK=verifyGolfField();
        boolean holes_OK=verifyHoles();

        if (gf_OK && holes_OK){

            golfFieldUri=insertGolfField(context);

            if (golfFieldUri!=null){

                golfField_id=ContentUris.parseId(golfFieldUri);

                setGolfField_id_Holes();

                qtyInsertedHoles=bulkInsertHoles(context);

                if (qtyInsertedHoles!=18){

                    //Borrar GolfField y hoyos

                    golfField_id=INVALID_GOLF_FIELD_ID;


                }else{

                }



            }else{
                golfField_id=INVALID_GOLF_FIELD_ID;
            }


        }else{

            golfField_id=INVALID_GOLF_FIELD_ID;
        }


        return golfField_id;


    }




    private boolean verifyGolfField (){
        return true;
    }

    private boolean verifyHoles(){
        return true;
    }

    private Uri insertGolfField(Context context){

        Uri allGolfFieldUri=ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri();
        Uri insertedGolfField=context.getContentResolver().insert(allGolfFieldUri,getGolfFieldValues());

        return insertedGolfField;

    }



    private int bulkInsertHoles(Context context){

        int quantityOfInsertedHoles=0;

        return quantityOfInsertedHoles;

    }


    private void setGolfField_id_Holes(){

    }










}
