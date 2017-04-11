package com.montoya.gabi.scorecard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.test.ProviderTestCase2;

import com.montoya.gabi.scorecard.model.data.ScorecardContract;
import com.montoya.gabi.scorecard.model.data.ScorecardDbHelper;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gabriel on 11/04/2017.
 */

public class TestDb extends AndroidTestCase {

    private TestUtils mTestUtils=new TestUtils();



    @Override
    protected void setUp() throws Exception {
        mTestUtils.deleteTheDatabase(mContext);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreateDB(){


        mTestUtils.deleteTheDatabase(mContext);


        // Add the table names within the HashSet
        final HashSet<String> tablenameHasSet= new HashSet<String>();
        tablenameHasSet.add(ScorecardContract.GolfFieldEntry.TABLE_NAME);



        //Check if the database is created and Opened correctly
        mContext.deleteDatabase(ScorecardDbHelper.DATABASE_NAME);
        SQLiteDatabase db=new ScorecardDbHelper(mContext).getWritableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());


        //have we created the tables we want?
        Cursor c= db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'",null);
        assertTrue("Error: Database is not created correctly - No tables created",c.moveToFirst());



        // verify that the tables have been created
        // we remove from the hash table all the records in the cursos which has all the table names, if at the end the hashtable is not empty that means that not all tables were created.
        do {
            tablenameHasSet.remove(c.getString(0));
        }while (c.moveToNext());

        assertTrue("Error: Database is not created correctly - Some tables were created wrongly",tablenameHasSet.isEmpty());


        c.close();
        db.close();

    }





    public void testTableGolfFieldStructure(){


        final HashSet<String> moviesColumnHashSet=new HashSet<String>();
        moviesColumnHashSet.add(ScorecardContract.GolfFieldEntry._ID);
        moviesColumnHashSet.add(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_NAME);
        moviesColumnHashSet.add(ScorecardContract.GolfFieldEntry.COLUMN_GOLF_FIELD_FAVORITE);


        SQLiteDatabase db=new ScorecardDbHelper(mContext).getReadableDatabase();
        assertEquals("Error: Database is not opened correctly",true,db.isOpen());

        Cursor cursor=db.rawQuery("PRAGMA table_info("+ ScorecardContract.GolfFieldEntry.TABLE_NAME+")",null);
        assertTrue("Error: This means that we were unable to query the database for table information.",
                cursor.moveToFirst());

        int columnNameIndex= cursor.getColumnIndex("name");

        do {
            String columnName = cursor.getString(columnNameIndex);
            moviesColumnHashSet.remove(columnName);
        } while(cursor.moveToNext());

        assertTrue("Error: The table "+ScorecardContract.GolfFieldEntry.TABLE_NAME +" doesn't contain all of the required  columns",moviesColumnHashSet.isEmpty());

        cursor.close();
        db.close();

    }







}
