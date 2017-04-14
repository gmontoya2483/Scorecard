package com.montoya.gabi.scorecard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.montoya.gabi.scorecard.model.GolfField;
import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardDbHelper;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

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

        return qtyOfDeletedRecords;



    }



    public static void VerifyExpectedGolfFieldQueryResult(GolfField golfField, Cursor cursorGolfField){

        GolfField golfFieldFromCursor=new GolfField(cursorGolfField);

        assertEquals("Error: Golf Field ID doesn´t Match", golfField.getId(),golfFieldFromCursor.getId());
        assertEquals("Error: Golf Field Name doesn´t Match",golfField.getName(),golfFieldFromCursor.getName());
        assertEquals("Error: Golf Field favorite doesn´t Match",golfField.getFavorite(),golfFieldFromCursor.getFavorite());

    }







}
