package com.montoya.gabi.scorecard.model;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardContract.ScorecardBoolean;
import com.montoya.gabi.scorecard.utils.ScorecardUtils;

/**
 * Created by montoya on 10.04.2017.
 */

public class GolfField {


    public static final Long INVALID_GOLF_FIELD_ID=-1L;
    public static final Long NOT_SAVED_GOLF_FIELD_ID=0L; //Default id when the golffield whasent been saved into the Database
    public static final int INVALID_TOTAL_LENGTH=-1;
    public static final int INVALID_TOTAL_PAR=-1;
    public static final int QUANTITY_OF_HOLES=18;

    private long _id;
    private String name;
    private int favorite;
    private int active;

    private GolfFieldHole holes []=new GolfFieldHole[18];

    private int out_length=INVALID_TOTAL_LENGTH;
    private int in_length=INVALID_TOTAL_LENGTH;
    private int in_par=INVALID_TOTAL_PAR;
    private int out_par=INVALID_TOTAL_PAR;


    public GolfField(String name, ScorecardBoolean favorite, ScorecardBoolean active) {

        setGolfFieldAttributes(name, favorite, active);

    }


    public GolfField(String name, ScorecardBoolean favorite, ScorecardBoolean active, GolfFieldHole[] holes) {

        this.name=name;
        this.favorite=favorite.getValue();
        this.active= active.getValue();

       setHolesFromArray(holes);

    }



    public GolfField (long _id, String name, ScorecardBoolean favorite, ScorecardBoolean active){
        this._id=_id;
        this.name=name;
        this.favorite=favorite.getValue();
        this.active=active.getValue();
    }


    //Constructor helper methed to setup the att
    private void setGolfFieldAttributes(String name, ScorecardBoolean favorite, ScorecardBoolean active){

        this._id=NOT_SAVED_GOLF_FIELD_ID;
        this.name=name;
        this.favorite=favorite.getValue();
        this.active= active.getValue();

    }



    public GolfField (Cursor golfFieldCursor){

        setGolfFieldValuesFromCursor(golfFieldCursor);

    }


    public GolfField (Context context, long golfField_id){

        Uri golfFieldByIdUri=ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField_id);
        Cursor cursor=context.getContentResolver().query(golfFieldByIdUri,null,null,null,null);
        setGolfFieldValuesFromCursor(cursor);

    }


    private void setGolfFieldValuesFromCursor(Cursor golfFieldCursor){

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

    public void setName(String name){
        this.name=name;
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


    public void setFavorite(ScorecardBoolean favorite){

        this.favorite=favorite.getValue();
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

    public void setActive(ScorecardBoolean active){

        this.active=active.getValue();
    }


    //Get the content values without the _ID
    public ContentValues getGolfFieldValues (){

        ContentValues values=new ContentValues();
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME,this.name);
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE,this.favorite);
        values.put(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_ACTIVE,this.active);

        return values;

    }


    public int getOut_length() {
        return out_length;
    }

    public int getIn_length() {
        return in_length;
    }

    public int getIn_par() {
        return in_par;
    }

    public int getOut_par() {
        return out_par;
    }

    public int getTotal_length() {

        int total;

        if (this.out_length==INVALID_TOTAL_LENGTH || this.in_length==INVALID_TOTAL_LENGTH){
            total=INVALID_TOTAL_LENGTH;
        }else{
            total=this.out_length+this.in_length;
        }

        return total;

    }


    public int getTotal_par() {
        int par;

        if (this.out_par==INVALID_TOTAL_PAR || this.in_par==INVALID_TOTAL_PAR){
            par=INVALID_TOTAL_LENGTH;
        }else{
            par=this.out_par+this.in_par;
        }

        return par;
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


        if (holes.length<=QUANTITY_OF_HOLES){

            for (GolfFieldHole hole : holes) {
                int index = AddHole(hole);
            }

        }

    }


    public boolean loadHolesFromDB(Context context){

        boolean result=true;

        Uri holesByGolfFielIdUri=ScorecardContract.GolfFieldHoleEntry.buildAllGolfFieldsHolesByFieldUri(this._id);
        Cursor cursor=context.getContentResolver().query(holesByGolfFielIdUri,null,null,null,null);

        int index_Id=cursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry._ID);
        int indexGF_Id=cursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_GF_ID);
        int indexNumber=cursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_NUMBER);
        int indexLength=cursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_LENGTH);
        int indexPar=cursor.getColumnIndex(ScorecardContract.GolfFieldHoleEntry.COLUMN_GOLF_FIELD_HOLE_PAR);


        long id;
        long GF_Id;
        Hole.HoleNumber number;
        int length;
        Hole.Par par;

        if (cursor.getCount()==QUANTITY_OF_HOLES){

            this.holes= new GolfFieldHole[QUANTITY_OF_HOLES];//Remove old data from holes to begin from scratch

            while (cursor.moveToNext()){

                id=cursor.getLong(index_Id);
                GF_Id=cursor.getLong(indexGF_Id);
                number=Hole.convertIntToHoleNumber(cursor.getInt(indexNumber));
                length=cursor.getInt(indexLength);
                par=Hole.convertIntToPar(cursor.getInt(indexPar));

                Log.i(ScorecardUtils.APP_LOG_TAG,this.getName()+" - _id: "+id+" GF_ID: "+GF_Id+" Number: "+number+" length: "+length+" Par: "+par);

                this.AddHole(new GolfFieldHole(id,GF_Id,number,length,par));

            }

            result=verifyHoles();

        }else {
            result=false;

        }

        if (result){
            calculateTotals(); // if everything is OK calculate the totals from the holes

        }else{
            this.holes= new GolfFieldHole[QUANTITY_OF_HOLES]; //If there was a fail blank the holes array
        }

        return result;
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

            if (this._id!=GolfField.NOT_SAVED_GOLF_FIELD_ID && this._id!=GolfField.INVALID_GOLF_FIELD_ID){

                saved_gf_OK=true;

            }else{

                saved_gf_OK=false;

            }

        }else {
            saved_gf_OK=false;
        }

        return saved_gf_OK;

    }




    //Helper Method to calculate the totals (par in, par out, length in, length out)
    private void calculateTotals(){

        this.out_length=0;
        this.in_length=0;
        this.in_par=0;
        this.out_par=0;

        for (int i=0;i<QUANTITY_OF_HOLES;i++){

            if (i<=8){
                // this is the out
                this.out_length=this.out_length+holes[i].getLength();
                this.out_par=this.out_par+holes[i].getPar().getValue();

            }else{
                // this is the in
                this.in_length=this.in_length+holes[i].getLength();
                this.in_par=this.in_par+holes[i].getPar().getValue();

            }

        }


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

                    qtyInsertedHoles=GolfFieldHole.bulkInsertGolfFieldHoles(context,this.holes);

                    if (qtyInsertedHoles!=18){

                        //if the quantity of inserted holes is not 18, the holes that were inseeted are deleted and the golffield is deleted.
                        GolfFieldHole.deleteGolfFieldHolesByGolfFieldId(context,this._id);
                        deleteGolfField(context, this._id);

                        //The golffield id is set as invalid
                        this._id=INVALID_GOLF_FIELD_ID;


                    }else{

                        // OK!!! DO NOTHING....

                    }

                }else{

                    //if the verification of the holes before inserting them is not OK the inserted Golffield is deleted.
                    deleteGolfField(context, this._id);

                    //The golffield id is set as invalid
                    this._id=INVALID_GOLF_FIELD_ID;

                }


            }else{
                this._id=INVALID_GOLF_FIELD_ID;
            }


        }else{
            //if the verification of the GOlfField fields are not OK, The golf field id is set as invalid
            this._id=INVALID_GOLF_FIELD_ID;
        }


    }



    //Helper method used during the insert GolfFields it verifies:
    //Name is not null
    // Favorite flag have either 1 -> ScorecardBoolean.TRUE or 0 -> ScorecardBoolean.FALSE
    // Active flag have either 1 -> ScorecardBoolean.TRUE or 0 -> ScorecardBoolean.FALSE
    private boolean verifyGolfField (){

        boolean golfField_OK=true;

        //Verify the name is not null
        if (this.name==null || this.name.trim().equals("")){
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


    //Helper method used during the insert GolfFields it verifies:
    //All holes were added (18)
    //That all holes has a length bigger than 0
    //That all PAR values are OK (PAR_3 or PAR_4 or PAR_5)
    //That all the holes have the correct number (hole(0)-> HOLE_1..... hole(17) -> HOLE_18
    private boolean verifyHoles(){
        boolean holes_OK=true;

        for (int i=0; i<18;i++){

            if (holes[i]!=null){

                //Verify the golf field ID
                if (holes[i].getGolfField_id()!=this._id){
                    holes_OK=false;
                }

                //Verify the Length is not invalid
                if (holes[i].getLength()==Hole.INVALID_HOLE_LENGTH){
                    holes_OK=false;
                }

                //Verify the Length is not NOT DEFINED
                if (holes[i].getLength()==Hole.NOT_DEFINED_HOLE_LENGTH){
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



    //Helper Method for inserting a Golf field from the database
    private Uri insertGolfField(Context context){
        Uri allGolfFieldUri=ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri();
        return context.getContentResolver().insert(allGolfFieldUri,getGolfFieldValues());
    }


    //Helper Method which set the golffield ID to all the holes before saving
    private void setGolfField_idToHoles(){

        for(int i=0;i<holes.length;i++){

            if (holes[i]!=null){
                holes[i].setGolfField_id(this._id);
            }

        }

    }


    //Helper Method for deleting a Golf field from the database
    private int deleteGolfField (Context context, long golfField_id){
       return context.getContentResolver().delete(ScorecardContract.GolfFieldEntry.buildGolfFieldByIdUri(golfField_id),null,null);
    }




    //TODO hacer este metodo
    public void DeleteGolfField(){

        //Chequear si existen ScoreCards para este Golfield o si hay una current tarjeta

        //Si hay algo marcarlos como inactivo


        //Si no hay nada borrarlo (GolfField holes y el golfField)

    }



    //Helper method to get the quantity of saved golf field (both active and inactive)
    public static int getQuantityOfGolfFields(Context context){

        int qty;
        Cursor cursor;
        Uri allGolfFiedUri=ScorecardContract.GolfFieldEntry.buildAllGolfFieldsUri();
        cursor=context.getContentResolver().query(allGolfFiedUri,null,null,null,null);

        if (cursor!=null){
            qty=cursor.getCount();
        }else {
            qty=0;
        }
        return qty;

    }


    //Helper method to get the quantity of saved golf field (both active and inactive)
    public static int getQuantityOfActiveGolfFields(Context context){

        int qty;
        Cursor cursor;
        Uri allGolfFiedUri=ScorecardContract.GolfFieldEntry.buildAllGolfFieldsActiveUri();
        cursor=context.getContentResolver().query(allGolfFiedUri,null,null,null,null);

        if (cursor!=null){
            qty=cursor.getCount();
        }else {
            qty=0;
        }
        return qty;

    }
















}
