package com.montoya.gabi.scorecard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardDbHelper;

/**
 * Created by Gabriel on 28/04/2017.
 */

public class testSetup extends AndroidTestCase {


    public void testInsertedData(){

        //Verify the is opened correctly
        SQLiteDatabase db=new ScorecardDbHelper(this.mContext).getReadableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());


        Cursor cursorGFH=db.rawQuery("SELECT * FROM "+ ScorecardContract.GolfFieldEntry.TABLE_NAME,null);
        assertEquals("Cantidad de registros",cursorGFH.getCount(),4);

    }


}
