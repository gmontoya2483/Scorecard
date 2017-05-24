package com.montoya.gabi.scorecard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.GolfFieldHole;
import com.montoya.gabi.scorecard.model.Hole;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardDbHelper;

import static com.montoya.gabi.scorecard.model.GolfField.NOT_SAVED_GOLF_FIELD_ID;
import static junit.framework.Assert.*;


/**
 * Created by montoya on 11.04.2017.
 */

public class TestUtils {



    // Since we want each test to start with a clean slate
    public static void deleteTheDatabase(Context context) {

        context.deleteDatabase(ScorecardDbHelper.DATABASE_NAME);
    }




    public static int deleteAllGolfFieldrecords(Context context){

        Cursor cursor;
        SQLiteDatabase db=new ScorecardDbHelper(context).getWritableDatabase();
        int qtyOfDeletedRecords=db.delete(ScorecardContract.GolfFieldEntry.TABLE_NAME,null,null);

        cursor=db.rawQuery("SELECT "+ScorecardContract.GolfFieldEntry._ID+" FROM "+ScorecardContract.GolfFieldEntry.TABLE_NAME,null);
        assertFalse("Error: deleteAllGolfField - No all field records were deleted",cursor.moveToFirst());

        db.close();
        cursor.close();

        return qtyOfDeletedRecords;



    }



    public static void VerifyExpectedGolfFieldQueryResult(GolfField golfField, Cursor cursorGolfField){

        GolfField golfFieldFromCursor=new GolfField(cursorGolfField);

        assertEquals("Error: Golf Field ID doesn´t Match", golfField.get_id(),golfFieldFromCursor.get_id());
        assertEquals("Error: Golf Field Name doesn´t Match",golfField.getName(),golfFieldFromCursor.getName());
        assertEquals("Error: Golf Field favorite doesn´t Match",golfField.getFavorite(),golfFieldFromCursor.getFavorite());
        assertEquals("Error: Golf Field active doesn´t Match",golfField.getActive(),golfFieldFromCursor.getActive());


    }


    public static void VerifyExpectedGolfFieldHoleQueryResult(GolfFieldHole golfFieldHole, Cursor cursorGolfFieldHole){

        GolfFieldHole golfFieldHoleFromCursor=new GolfFieldHole(cursorGolfFieldHole);

        assertEquals("Error: Golf Field Hole ID doesn´t Match", golfFieldHole.get_id(),golfFieldHoleFromCursor.get_id());
        assertEquals("Error: Golf Field  ID doesn´t Match", golfFieldHole.getGolfField_id(),golfFieldHoleFromCursor.getGolfField_id());
        assertEquals("Error: Golf Field Number doesn´t Match", golfFieldHole.getNumber().getValue(),golfFieldHoleFromCursor.getNumber().getValue());
        assertEquals("Error: Golf Field Length doesn´t Match", golfFieldHole.getLength(),golfFieldHoleFromCursor.getLength());
        assertEquals("Error: Golf Field Par doesn´t Match", golfFieldHole.getPar().getValue(),golfFieldHoleFromCursor.getPar().getValue());


    }




    public static int deleteAllGolfFieldHoleRecords(Context context){

        Cursor cursor;
        SQLiteDatabase db=new ScorecardDbHelper(context).getWritableDatabase();
        int qtyOfDeletedRecords=db.delete(ScorecardContract.GolfFieldHoleEntry.TABLE_NAME,null,null);

        cursor=db.rawQuery("SELECT "+ScorecardContract.GolfFieldHoleEntry._ID+" FROM "+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME,null);
        assertFalse("Error: deleteAllGolfFieldHole - Not all hole records were deleted",cursor.moveToFirst());

        db.close();
        cursor.close();

        return qtyOfDeletedRecords;



    }

    public static void deleteAllRecords (Context context){

        TestUtils.deleteAllGolfFieldHoleRecords(context);
        TestUtils.deleteAllGolfFieldrecords(context);

    }


    public static Cursor getAllGolfFieldHoles(Context context){
        Cursor cursor;

        SQLiteDatabase db=new ScorecardDbHelper(context).getWritableDatabase();
        if (db.isOpen()){

            String SQLStatment="SELECT * from "+ScorecardContract.GolfFieldHoleEntry.TABLE_NAME;

            cursor=db.rawQuery(SQLStatment,null);

        }else{
            cursor=null;
        }
        return cursor;
    }



    public static GolfField insertFakeGolfField(Context context, String golfFieldName, ScorecardContract.ScorecardBoolean isFavorite, ScorecardContract.ScorecardBoolean isActive) {


        String gf_name=golfFieldName;
        ScorecardContract.ScorecardBoolean gf_favorite= isFavorite;
        ScorecardContract.ScorecardBoolean gf_active= isActive;

        GolfField golfField=new GolfField(gf_name,gf_favorite,gf_active);

        /*
        * Add the Holes
         */

        //Hole 1:
        GolfFieldHole hole_1=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_1,120, Hole.Par.PAR_3);
        golfField.AddHole(hole_1);

        //Hole 2:
        GolfFieldHole hole_2=new GolfFieldHole(235L, Hole.HoleNumber.HOLE_2,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_2);

        //Hole 3:
        GolfFieldHole hole_3=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_3,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_3);


        //Hole 4:
        GolfFieldHole hole_4=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_4,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_4);


        //Hole 5:
        GolfFieldHole hole_5=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_5,370, Hole.Par.PAR_5);
        golfField.AddHole(hole_5);


        //Hole 6:
        GolfFieldHole hole_6=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_6,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_6);


        //Hole 7:
        GolfFieldHole hole_7=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_7,265, Hole.Par.PAR_4);
        golfField.AddHole(hole_7);

        //Hole 8:
        GolfFieldHole hole_8=new GolfFieldHole(235L, Hole.HoleNumber.HOLE_8,220, Hole.Par.PAR_4);
        golfField.AddHole(hole_8);

        //Hole 9:
        GolfFieldHole hole_9=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_9,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_9);

        //Hole 10:
        GolfFieldHole hole_10=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_10,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_10);

        //Hole 11:
        GolfFieldHole hole_11=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_11,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_11);

        //Hole 12:
        GolfFieldHole hole_12=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_12,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_12);

        //Hole 13:
        GolfFieldHole hole_13=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_13,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_13);

        //Hole 14:
        GolfFieldHole hole_14=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_14,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_14);

        //Hole 15:
        GolfFieldHole hole_15=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_15,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_15);


        //Hole 16:
        GolfFieldHole hole_16=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_16,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_16);


        //Hole 17:
        GolfFieldHole hole_17=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_17,250, Hole.Par.PAR_4);
        golfField.AddHole(hole_17);

        //Hole 18:
        GolfFieldHole hole_18=new GolfFieldHole(NOT_SAVED_GOLF_FIELD_ID, Hole.HoleNumber.HOLE_18,350, Hole.Par.PAR_5);
        golfField.AddHole(hole_18);


        boolean insertedOK=golfField.InsertGolfField(context);

        if (insertedOK){
            return golfField;
        }else{
            assertTrue("Golf field was not inserted correctly",insertedOK);
            return null;
        }

    }


}
