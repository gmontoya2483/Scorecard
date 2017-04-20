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

        this._id=NOT_SAVED_GOLF_FIELD_ID;
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

            for (GolfFieldHole hole : holes) {
                int index = AddHole(hole);
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


    public boolean InsertGolfField(Context context){

        boolean saved_gf_OK;


        if (this._id==GolfField.NOT_SAVED_GOLF_FIELD_ID || this._id==GolfField.INVALID_GOLF_FIELD_ID){
           insertGolfFieldWithHoles(context);

            if (this._id!=GolfField.NOT_SAVED_GOLF_FIELD_ID || this._id!=GolfField.INVALID_GOLF_FIELD_ID){

                saved_gf_OK=true;

            }else{

                saved_gf_OK=false;

            }

        }else {
            saved_gf_OK=false;
        }

        return saved_gf_OK;

    }



    //Helper Method to insert a new GolfField
    private void insertGolfFieldWithHoles(Context context){

        Long golfField_id;
        Uri golfFieldUri;
        int qtyInsertedHoles;
        boolean holes_OK;
        boolean gf_OK;


        gf_OK=verifyGolfField();


        if (gf_OK){

            golfFieldUri=insertGolfField(context);

            if (golfFieldUri!=null){

                this._id=ContentUris.parseId(golfFieldUri);

                setGolfField_idToHoles();
                holes_OK=verifyHoles();

                if (holes_OK){

                    qtyInsertedHoles=bulkInsertHoles(context);

                    if (qtyInsertedHoles!=18){

                        //TODO Delete Holes and GolfField (Hacer los provider y los metodos

                        this._id=INVALID_GOLF_FIELD_ID;


                    }else{

                        //TODO OK!!! DO NOTHING....

                    }

                }else{

                    //TODO Delete GolfField
                    this._id=INVALID_GOLF_FIELD_ID;

                }


            }else{
                this._id=INVALID_GOLF_FIELD_ID;
            }


        }else{

            this._id=INVALID_GOLF_FIELD_ID;
        }


    }




    private boolean verifyGolfField (){

        boolean golfField_OK=true;

        //Verify the name is not null
        if (this.name==null){
            golfField_OK=false;
        }

        //Verify the favorite flag
        if (this.favorite!= ScorecardBoolean.TRUE.getValue() && this.favorite!= ScorecardBoolean.FALSE.getValue()){
            golfField_OK=false;
        }

        //Verify the active flag
        if (this.active!= ScorecardBoolean.TRUE.getValue() && this.active!= ScorecardBoolean.FALSE.getValue()){
            golfField_OK=false;
        }


        return golfField_OK;
    }



    private boolean verifyHoles(){
        boolean holes_OK=true;

        for (int i=0; i<18;i++){

            if (holes[i]!=null){

                //Verify the golf field ID
                if (holes[i].getGolfField_id()!=this._id){
                    holes_OK=false;
                }

                //Verify the Length Must be bigger than 0
                if (holes[i].getLength()<=0){
                    holes_OK=false;
                }

                //Verify the PAR
                if (holes[i].getPar()!= Hole.Par.PAR_3 && holes[i].getPar()!= Hole.Par.PAR_4 && holes[i].getPar()!= Hole.Par.PAR_5){
                    holes_OK=false;
                }

                //Verify Hole Number
                switch (i){
                    case 0:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_1){
                            holes_OK=false;
                        }
                        break;

                    case 1:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_2){
                            holes_OK=false;
                        }
                        break;

                    case 2:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_3){
                            holes_OK=false;
                        }
                        break;

                    case 3:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_4){
                            holes_OK=false;
                        }
                        break;

                    case 4:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_5){
                            holes_OK=false;
                        }
                        break;

                    case 5:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_6){
                            holes_OK=false;
                        }
                        break;

                    case 6:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_7){
                            holes_OK=false;
                        }
                        break;

                    case 7:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_8){
                            holes_OK=false;
                        }
                        break;

                    case 8:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_9){
                            holes_OK=false;
                        }
                        break;

                    case 9:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_10){
                            holes_OK=false;
                        }
                        break;

                    case 10:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_11){
                            holes_OK=false;
                        }
                        break;

                    case 11:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_12){
                            holes_OK=false;
                        }
                        break;

                    case 12:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_13){
                            holes_OK=false;
                        }
                        break;

                    case 13:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_14){
                            holes_OK=false;
                        }
                        break;

                    case 14:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_15){
                            holes_OK=false;
                        }
                        break;

                    case 15:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_16){
                            holes_OK=false;
                        }
                        break;

                    case 16:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_17){
                            holes_OK=false;
                        }
                        break;

                    case 17:
                        if (holes[i].getNumber()!= Hole.HoleNumber.HOLE_18){
                            holes_OK=false;
                        }
                        break;
                }


            }else {
                // If not all the holes were added
                holes_OK=false;
            }

        }


        return holes_OK;
    }



    private Uri insertGolfField(Context context){

        Uri allGolfFieldUri=ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri();

        return context.getContentResolver().insert(allGolfFieldUri,getGolfFieldValues());

    }



    //TODO PASARLO COMO STATICO A GOLFFIELD HOLE
    private int bulkInsertHoles(Context context){

        int quantityOfInsertedHoles=0;


        //TODO Finish the Method

        return quantityOfInsertedHoles;

    }


    private void setGolfField_idToHoles(){

        //TODO Finish the Method

    }










}
